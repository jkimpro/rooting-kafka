package com.gsshop.kafka.config.datasource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.EmptyInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateQueryInterceptor extends EmptyInterceptor {
    private static final long   serialVersionUID = -8462685961591617861L;
    private static final String MAX_COUNT        = "10000";
    
    @Override
    public String onPrepareStatement(String sql) {
        log.debug("HibernateQueryInterceptor.onPrepareStatement SQL Value : " + sql);
        // Insert Query Comment
        if (sql.startsWith("/* ")) {
            String comment = StringUtils.substringBetween(sql, "/* ", "*/");
            comment = " /* ".concat(comment).concat("*/");
            sql = StringUtils.substring(sql, comment.length());
            int index = sql.indexOf(" ");
            String query = StringUtils.substring(sql, 0, index).trim();
            sql = sql.replaceFirst(query, query.concat(comment));
        }
        
        // Maximum limit
        if (sql.startsWith("SELECT /*") || sql.startsWith("select /*")) {
            int dualFlag = sql.indexOf("DUAL");
            if (!(dualFlag > 0 || dualFlag > 0)) {
                sql = "SELECT * FROM (" + sql + ") WHERE ROWNUM <= " + MAX_COUNT;
            }
        }
        
        return super.onPrepareStatement(sql);
    }
}
