    package com.gsshop.kafka.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsshop.kafka.consumer.model.MpAttrPrcHVo;
import com.gsshop.kafka.consumer.model.MpAttrPrdDVo;
import com.gsshop.kafka.consumer.model.MpAttrPrdMVo;
import com.gsshop.kafka.consumer.model.MpChanlChgLVo;
import com.gsshop.kafka.consumer.model.MpChanlDVo;
import com.gsshop.kafka.consumer.model.MpCntntChgHVo;
import com.gsshop.kafka.consumer.model.MpCntntDVo;
import com.gsshop.kafka.consumer.model.MpColChgLVo;
import com.gsshop.kafka.consumer.model.MpColorImgDVo;
import com.gsshop.kafka.consumer.model.MpDescdGenrlDVo;
import com.gsshop.kafka.consumer.model.MpDescdHtmlDVo;
import com.gsshop.kafka.consumer.model.MpDtrDVo;
import com.gsshop.kafka.consumer.model.MpExplnDVo;
import com.gsshop.kafka.consumer.model.MpExposDVo;
import com.gsshop.kafka.consumer.model.MpMetaDVo;
import com.gsshop.kafka.consumer.model.MpMontrnExcptDVo;
import com.gsshop.kafka.consumer.model.MpNmChgHVo;
import com.gsshop.kafka.consumer.model.MpNoteDVo;
import com.gsshop.kafka.consumer.model.MpOrdPsblQtyDVo;
import com.gsshop.kafka.consumer.model.MpOrdPsblQtyLVo;
import com.gsshop.kafka.consumer.model.MpPrcHVo;
import com.gsshop.kafka.consumer.model.MpPrdDVo;
import com.gsshop.kafka.consumer.model.MpPrdMVo;
import com.gsshop.kafka.consumer.model.MpPreOrdngLVo;
import com.gsshop.kafka.consumer.model.MpSafeCertDVo;
import com.gsshop.kafka.consumer.model.MpShopExposDVo;
import com.gsshop.kafka.consumer.model.MpSpecDVo;
import com.gsshop.kafka.consumer.model.MpStockDVo;
import com.gsshop.kafka.consumer.model.MpUdaDVo;
import com.gsshop.kafka.consumer.service.KafkaPrdAttrPrdMService;
import com.gsshop.kafka.consumer.service.KafkaPrdAttrService;
import com.gsshop.kafka.consumer.service.KafkaPrdChanlChgLService;
import com.gsshop.kafka.consumer.service.KafkaPrdChanlDService;
import com.gsshop.kafka.consumer.service.KafkaPrdCntntChgHService;
import com.gsshop.kafka.consumer.service.KafkaPrdCntntDService;
import com.gsshop.kafka.consumer.service.KafkaPrdColChgLService;
import com.gsshop.kafka.consumer.service.KafkaPrdColorImgDService;
import com.gsshop.kafka.consumer.service.KafkaPrdDescdGenrlDService;
import com.gsshop.kafka.consumer.service.KafkaPrdDescdHtmlDService;
import com.gsshop.kafka.consumer.service.KafkaPrdDtrDService;
import com.gsshop.kafka.consumer.service.KafkaPrdExplnDService;
import com.gsshop.kafka.consumer.service.KafkaPrdExposDService;
import com.gsshop.kafka.consumer.service.KafkaPrdMetaDService;
import com.gsshop.kafka.consumer.service.KafkaPrdMontrnExcptDService;
import com.gsshop.kafka.consumer.service.KafkaPrdNmChgHService;
import com.gsshop.kafka.consumer.service.KafkaPrdNoteDService;
import com.gsshop.kafka.consumer.service.KafkaPrdOrdPsblQtyDService;
import com.gsshop.kafka.consumer.service.KafkaPrdOrdPsblQtyLService;
import com.gsshop.kafka.consumer.service.KafkaPrdPrcHService;
import com.gsshop.kafka.consumer.service.KafkaPrdPrdDService;
import com.gsshop.kafka.consumer.service.KafkaPrdPrdMService;
import com.gsshop.kafka.consumer.service.KafkaPrdPreOrdngLService;
import com.gsshop.kafka.consumer.service.KafkaPrdSafeCertDService;
import com.gsshop.kafka.consumer.service.KafkaPrdShopExposDService;
import com.gsshop.kafka.consumer.service.KafkaPrdSpecDService;
import com.gsshop.kafka.consumer.service.KafkaPrdStockDService;
import com.gsshop.kafka.consumer.service.KafkaPrdUdaDService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private KafkaPrdDescdGenrlDService kafkaPrdDescdGenrlDService;
	
	@Autowired
	private KafkaPrdDescdHtmlDService kafkaPrdDescdHtmlDService;
	
	@Autowired
	private KafkaPrdDtrDService kafkaPrdDtrDService;
	
	@Autowired
	private KafkaPrdExplnDService kafkaPrdExplnDService;
	
	@Autowired
	private KafkaPrdPrdMService kafkaPrdPrdMService;
	
	@Autowired
	private KafkaPrdPrdDService kafkaPrdPrdDService;
	
	@Autowired
	private KafkaPrdSafeCertDService kafkaPrdSafeCertDService;
	
	@Autowired
	private KafkaPrdShopExposDService kafkaPrdShopExposDService;
	
	@Autowired
	private KafkaPrdSpecDService kafkaPrdSpecDService;

	@Autowired
	private KafkaPrdStockDService kafkaPrdStockDService;
	
	@Autowired
	private KafkaPrdExposDService kafkaPrdExposDService;
	
	@Autowired
	private KafkaPrdMetaDService kafkaPrdMetaDService;
	
	@Autowired
	private KafkaPrdMontrnExcptDService kafkaPrdMontrnExcptDService;
	
	@Autowired
	private KafkaPrdNmChgHService kafkaPrdNmChgHService;
	
	@Autowired
	private KafkaPrdNoteDService kafkaPrdNoteDService;
	
	@Autowired
	private KafkaPrdOrdPsblQtyDService kafkaPrdOrdPsblQtyDService;
	
	@Autowired
	private KafkaPrdOrdPsblQtyLService 	kafkaPrdOrdPsblQtyLService;
										
	@Autowired
	private KafkaPrdPrcHService kafkaPrdPrcHService;
	
	@Autowired
	private KafkaPrdPreOrdngLService kafkaPrdPreOrdngLService;
	
	@Autowired
	private KafkaPrdChanlChgLService kafkaPrdChanlChgLService;
	
	@Autowired
	private KafkaPrdChanlDService kafkaPrdChanlDService;
	
	@Autowired
	private KafkaPrdCntntChgHService kafkaPrdCntntChgHService;
	
	@Autowired
	private KafkaPrdCntntDService kafkaPrdCntntDService;
	
	@Autowired
	private KafkaPrdColChgLService kafkaPrdColChgLService;
	
	@Autowired
	private KafkaPrdColorImgDService kafkaPrdColorImgDService;
	
	@Autowired
	private KafkaPrdUdaDService kafkaPrdUdaDService;
	
	@Autowired
	private KafkaPrdAttrPrdMService kafkaPrdAttrPrdMService;
	
	@Autowired
	private KafkaPrdAttrService kafkaPrdAttrService;
	
	@Autowired
	private KafkaPrdAttrService kafkaPrdAttrServiceMainStreamInit;
	
	
	
	
	//MP_PRD_M (상품 마스터 테이블)
    @KafkaListener(topics = "everest-mpPrdM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpPrdM(String mpPrdMJson) {
        try {
            Thread.sleep(10);
        } catch(InterruptedException e1) {
            e1.printStackTrace();
        }
        
        log.debug("Consumed JSON Message : {}", mpPrdMJson);
        
        for(int i =0; i<10; i++) {
        	log.debug("mpPrdJson got in : {}" + mpPrdMJson);
        }
        
        MpPrdMVo mpPrdMVo;

        try {
			mpPrdMVo = objectMapper.readValue(mpPrdMJson, MpPrdMVo.class);
			kafkaPrdPrdMService.setPrdPrdMService(mpPrdMVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    //MP_PRD_D (상품확장정보)
    @KafkaListener(topics = "everest-mpPrdD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpPrdD(String mpPrdDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
        
    	MpPrdDVo mpPrdDVo;
    	
    	try {
    		mpPrdDVo = objectMapper.readValue(mpPrdDJson, MpPrdDVo.class);
    		kafkaPrdPrdDService.setPrdPrdDService(mpPrdDVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    
    //MP_SAFE_CERT_D (상품안전인증정보)
    @KafkaListener(topics = "everest-mpSafeCertD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpSafeCertD(String mpSafeCertDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
        
    	MpSafeCertDVo mpSafeCertDVo;
    	
    	System.out.println("Consumed JSON Message : " + mpSafeCertDJson);
    	try {
    		mpSafeCertDVo = objectMapper.readValue(mpSafeCertDJson, MpSafeCertDVo.class);
    		kafkaPrdSafeCertDService.setPrdSafeCertDService(mpSafeCertDVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    //MP_SHOP_EXPOS_D (상품매장노출정보)
    @KafkaListener(topics = "everest-mpShopExposD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpShopExposD(String mpShopExposDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
        
    	MpShopExposDVo mpShopExposDVo;
    	
    	try {
    		mpShopExposDVo = objectMapper.readValue(mpShopExposDJson, MpShopExposDVo.class);
			kafkaPrdShopExposDService.setPrdShopExposDService(mpShopExposDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    //MP_SPEC_D (상품사양정보)
    @KafkaListener(topics = "everest-mpSpecD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpSpecD(String mpSpecDJson) {
//    	System.out.println("Consumed JSON Message : " + mpSpecDJson);
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpSpecDVo mpSpecDVo;
    	
    	try {
    		mpSpecDVo = objectMapper.readValue(mpSpecDJson, MpSpecDVo.class);
			kafkaPrdSpecDService.setPrdSpecDService(mpSpecDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
 
    //MP_STOCK_D (상품재고 정보)
    @KafkaListener(topics = "everest-mpStockD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpStockD(String mpStockDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpStockDVo mpStockDVo;
    	
    	try {
    		mpStockDVo = objectMapper.readValue(mpStockDJson, MpStockDVo.class);
			kafkaPrdStockDService.setPrdStockDService(mpStockDVo);
			
		} catch (JsonProcessingException e) {
			
			System.out.println("Consumed Object >>>>>>>>>>>>>>>>>Error" );
			e.printStackTrace();
		}
    }
    
    //MP_PRE_ORDNG_L (선발주 대상 로그)
    @KafkaListener(topics = "everest-mpPreOrdngL", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpPreOrdngL(String mpPreOrdngLJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpPreOrdngLVo mpPreOrdngLVo;
    	
    	try {
    		mpPreOrdngLVo = objectMapper.readValue(mpPreOrdngLJson, MpPreOrdngLVo.class);
			kafkaPrdPreOrdngLService.setPrdPreOrdngLService(mpPreOrdngLVo);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
    }
    
    //MP_META_D (상품메타정보)
    @KafkaListener(topics = "everest-mpMetaD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpMetaD(String mpMetaDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpMetaDVo mpMetaDVo;
    	
    	try {
    		mpMetaDVo = objectMapper.readValue(mpMetaDJson, MpMetaDVo.class);
			kafkaPrdMetaDService.setPrdMetaDService(mpMetaDVo);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
    }
    
    
    
    //MP_MONTRN_EXCPT_D (상품모니터링예외정보)
    @KafkaListener(topics = "everest-mpMontrnExcptD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpMontrnExcptD(String mpMontrnExcptDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpMontrnExcptDVo mpMontrnExcptDVo;
    	
    	try {
    		mpMontrnExcptDVo = objectMapper.readValue(mpMontrnExcptDJson, MpMontrnExcptDVo.class);
			kafkaPrdMontrnExcptDService.setPrdMontrnExcptDService(mpMontrnExcptDVo);
			
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
    }
    
    
    
    //MP_NM_CHG_H (상품명변경이력)
    @KafkaListener(topics = "everest-mpNmChgH", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpNmChgH(String mpNmChgHJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpNmChgHVo mpNmChgHVo;
    	
    	try {
    		mpNmChgHVo = objectMapper.readValue(mpNmChgHJson, MpNmChgHVo.class);
			kafkaPrdNmChgHService.setPrdNmChgHService(mpNmChgHVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    //MP_NOTE_D (상품비고정보)
    @KafkaListener(topics = "everest-mpNoteD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpNoteD(String mpNoteDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpNoteDVo mpNoteDVo;
    	
    	try {
    		mpNoteDVo = objectMapper.readValue(mpNoteDJson, MpNoteDVo.class);
			kafkaPrdNoteDService.setPrdNoteDService(mpNoteDVo);	
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    //MP_ORD_PSBL_QTY_D (상품주문가능수량정보)
    @KafkaListener(topics = "everest-mpOrdPsblQtyD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpOrdPsblQtyD(String mpOrdPsblQtyDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpOrdPsblQtyDVo mpOrdPsblQtyDVo;
    	
    	try {
    		mpOrdPsblQtyDVo = objectMapper.readValue(mpOrdPsblQtyDJson, MpOrdPsblQtyDVo.class);
			kafkaPrdOrdPsblQtyDService.setPrdOrdPsblQtyDService(mpOrdPsblQtyDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    //MP_ORD_PSBL_QTY_L (상품주문가능수량로그)
    @KafkaListener(topics = "everest-mpOrdPsblQtyL", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpOrdPsblQtyL(String mpOrdPsblQtyLJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpOrdPsblQtyLVo mpOrdPsblQtyLVo;
    	try {
    		mpOrdPsblQtyLVo = objectMapper.readValue(mpOrdPsblQtyLJson, MpOrdPsblQtyLVo.class);
    		kafkaPrdOrdPsblQtyLService.setPrdOrdPsblQtyLService(mpOrdPsblQtyLVo);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
    }
    
    
    //MP_PRC_H (상품가격이력)
    @KafkaListener(topics = "everest-mpPrcH", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpPrcH(String mpPrcHJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpPrcHVo mpPrcHVo;
    	
    	try {
    		mpPrcHVo = objectMapper.readValue(mpPrcHJson, MpPrcHVo.class);
			kafkaPrdPrcHService.setPrdPrcHService(mpPrcHVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
    }
    
    
    
    
    
//    MP_DESCD_GENRL_D (상품일반기술서정보)
    @KafkaListener(topics = "everest-mpDescdGenrlD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpDescdGenrlD(String mpDescdGenrlDJson) {
    	
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	MpDescdGenrlDVo mpDescdGenrlDVo;
    	
    	try {
    		mpDescdGenrlDVo = objectMapper.readValue(mpDescdGenrlDJson, MpDescdGenrlDVo.class);
    		kafkaPrdDescdGenrlDService.setPrdDescdGenrlDService(mpDescdGenrlDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	
    }
    
 
//    MP_DESCD_HTML_D (상품html기술서정보)
    @KafkaListener(topics = "everest-mpDescdHtmlD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpDescdHtmlD(String mpDescdHtmlDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	MpDescdHtmlDVo mpDescdHtmlDVo;
    	try {
    		mpDescdHtmlDVo = objectMapper.readValue(mpDescdHtmlDJson, MpDescdHtmlDVo.class);
    		kafkaPrdDescdHtmlDService.setPrdDescdHtmlDService(mpDescdHtmlDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
    }
    
//    MP_DTR_D (상품물류확장정보)
    @KafkaListener(topics = "everest-mpDtrD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpDtrD(String mpDtrDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpDtrDVo mpDtrDVo;
    	
    	try {
    		mpDtrDVo = objectMapper.readValue(mpDtrDJson, MpDtrDVo.class);
    		kafkaPrdDtrDService.setPrdDtrDService(mpDtrDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
//    MP_EXPLN_D (상품설명정보)
    @KafkaListener(topics = "everest-mpExplnD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpExplnD(String mpExplnDJson){
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpExplnDVo mpExplnDVo;
    	
    	try {
    		mpExplnDVo = objectMapper.readValue(mpExplnDJson, MpExplnDVo.class);
    		kafkaPrdExplnDService.setPrdExplnDService(mpExplnDVo);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}   	
    }
    

//    MP_EXPOS_D (상품노출확장정보)
    @KafkaListener(topics = "everest-mpExposD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpExposD(String mpExposDJson) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpExposDVo mpExposDVo;
    	
    	try {
    		mpExposDVo = objectMapper.readValue(mpExposDJson, MpExposDVo.class);
			kafkaPrdExposDService.setPrdExposDService(mpExposDVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}   	
    }
    
    
    //MP_CHANL_CHG_L (상품채널변경로그)
    @KafkaListener(topics = "everest-mpChanlChgL", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpChanlChgL(String mpChanlChgL) {
    	
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpChanlChgLVo mpChanlChgLVo; 
    
    	try {
    		mpChanlChgLVo = objectMapper.readValue(mpChanlChgL, MpChanlChgLVo.class);
    		kafkaPrdChanlChgLService.setPrdChanlChgLService(mpChanlChgLVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    //MP_CHANL_D (상품채널정보)
    @KafkaListener(topics = "everest-mpChanlD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpChanlD(String mpChanlD) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	MpChanlDVo mpChanlDVo;
    	
    	try {
    		mpChanlDVo = objectMapper.readValue(mpChanlD, MpChanlDVo.class);
    		kafkaPrdChanlDService.setPrdChanlDService(mpChanlDVo);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    //MP_CNTNT_CHG_H (상품컨텐츠변경이력)
    @KafkaListener(topics = "everest-mpCntntChgH", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpCntntChgH(String mpCntntChgH){
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpCntntChgHVo mpCntntChgHVo;
    	
    	try {
    		mpCntntChgHVo = objectMapper.readValue(mpCntntChgH, MpCntntChgHVo.class);
    		kafkaPrdCntntChgHService.setPrdCntntChgHService(mpCntntChgHVo);
    		
    	} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    
    //MP_CNTNT_D (상품컨텐츠상세)
    @KafkaListener(topics = "everest-mpCntntD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpCntntD(String mpCntntD) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpCntntDVo mpCntntDVo;
    	
    	try {
    		mpCntntDVo = objectMapper.readValue(mpCntntD, MpCntntDVo.class);
    		kafkaPrdCntntDService.setPrdCntntDService(mpCntntDVo);
    		
    	} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    //MP_COL_CHG_L (상품컬럼변경로그)
    @KafkaListener(topics = "everest-mpColChgL", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpColChgL(String mpColChgL) {
    	
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	MpColChgLVo mpColChgLVo;
    	
    	try {
    		mpColChgLVo = objectMapper.readValue(mpColChgL, MpColChgLVo.class);
    		kafkaPrdColChgLService.setPrdColChgLService(mpColChgLVo);
    	} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    
    }
    
  //MP_COLOR_IMG_D (상품색상이미지정보)
    @KafkaListener(topics = "everest-mpColorImgD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpColorImgD(String mpColorImgD) {
    	
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	log.debug("topic: everest-mpColorImgD data:" + mpColorImgD);
    	
    	MpColorImgDVo mpColorImgDVo;
    	
    	try {
    		mpColorImgDVo = objectMapper.readValue(mpColorImgD, MpColorImgDVo.class);
    		//date type mapping 오류 발생
    		//이부분 어떻게 해야할지?
    		
    		
    		log.debug("mpColorImgD Mapping Complete");
    		kafkaPrdColorImgDService.setPrdColorImgDService(mpColorImgDVo);
    	
    	} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

    	
    }
    
    //MP_UDA_D (상품uda정보)
    @KafkaListener(topics = "everest-mpUdaD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpUdaD(String mpUdaD) {
    	try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	MpUdaDVo mpUdaDVo;
    	
    	try {
    		mpUdaDVo = objectMapper.readValue(mpUdaD, MpUdaDVo.class);
    		kafkaPrdUdaDService.setPrdUdaDService(mpUdaDVo);
    	
    	} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    //MP_ATTR_PRD_M
    @KafkaListener(topics = "everest-mpAttrPrdM", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpAttrPrdM(String mpAttrPrdM) {
    	try {
    		Thread.sleep(10);
    	}
    	catch(InterruptedException e1) {
    		e1.printStackTrace();
    	}
    	MpAttrPrdMVo mpAttrPrdMVo;
    	
    	try {
    		mpAttrPrdMVo = objectMapper.readValue(mpAttrPrdM, MpAttrPrdMVo.class);
    		kafkaPrdAttrPrdMService.setPrdAttrPrdMService(mpAttrPrdMVo);
    	}
    	catch(JsonProcessingException e){
    		e.printStackTrace();
    	}
    }

    
    //TODO 신규 추가 테이블이여서 로직 구현 필요
    //everest-mpAttrPrcH
    @KafkaListener(topics = "everest-mpAttrPrcH", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpAttrPrcH(String mpAttrPrcH) {
    	try {
    		Thread.sleep(10);
    	}
    	catch(InterruptedException e1) {
    		e1.printStackTrace();
    	}
    	
    	MpAttrPrcHVo mpAttrPrcHVo;
    	
    	
    }

    //TODO 신규 추가 테이블이여서 로직 구현 필요
    //everest-mpAttrPrdD
    @KafkaListener(topics = "everest-mpAttrPrdD", containerFactory = "kafkaListenerContainerFactory")
    public void getJsonMpAttrPrdD(String mpAttrPrdD) {
    	try {
    		Thread.sleep(10);
    	}
    	catch(InterruptedException e1) {
    		e1.printStackTrace();
    	}
    
    	MpAttrPrdDVo mpAttrPrdDVo;    	
    }
    
    
   
}