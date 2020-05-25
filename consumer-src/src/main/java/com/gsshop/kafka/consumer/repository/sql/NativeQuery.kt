package com.gsshop.kafka.consumer.service.repository.sql

const val sampleQuery:String = """
     SELECT /* 여기에 식별 ID 지정 : 파일명.변수명 / 예) NativeQueryKt.sampleQuery */
             systimestamp
       FROM DUAL
         """