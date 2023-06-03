;**********************************************************************
;                                                                     *
;    Filename:	    xxx.asm                                           *
;    Date:                                                            *
;    File Version:                                                    *
;                                                                     *
;    Author:                                                          *
;    Company:                                                         *
;                                                                     *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Files Required: P16F887.INC                                      *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Notes:                                                           *
;                                                                     *
;**********************************************************************


	list		p=16f887	; list directive to define processor
	#include	<p16f887.inc>	; processor specific variable definitions


	__CONFIG    _CONFIG1, _LVP_OFF & _FCMEN_ON & _IESO_OFF & _BOR_OFF & _CPD_OFF & _CP_OFF & _MCLRE_ON & _PWRTE_ON & _WDT_OFF & _INTRC_OSC_NOCLKOUT
	__CONFIG    _CONFIG2, _WRT_OFF & _BOR21V

;******Configuracion de Puertos
	ORG     0x000             ; processor reset vector


;***** VARIABLE DEFINITIONS

	CBLOCK 	0X20
	ICO_8,TM_8VO,TV_8VO,BAJA,VAR_1
	ENDC



;**********************************************************************
	
	

	nop
  	goto    PORTS_CONFING              ; go to beginning of program



PORTS_CONFING

	BSF 	STATUS,RP0
	MOVLW 	0XFF
	MOVWF 	TRISA
	MOVWF 	TRISB
	MOVWF 	TRISC
	MOVLW 	0X00
	MOVWF 	TRISD
	MOVWF 	TRISE	

	BSF		STATUS,RP1
	CLRF 	ANSEL
	CLRF 	ANSELH
	BCF 	STATUS,RP0
	BCF		STATUS,RP1
	CLRF 	PORTA 
	CLRF 	PORTB 
	CLRF 	PORTC 
	CLRF 	PORTD 
	CLRF 	PORTE
	GOTO 	PRINCIPAL

PRINCIPAL
		
		BCF		PORTE,C
		MOVF  	PORTA,0
		MOVWF 	TM_8VO
		MOVF  	PORTB,0
		ADDWF 	TM_8VO,0
		MOVWF 	VAR_1
		MOVF  	PORTC,0
		SUBWF 	VAR_1,0
		MOVWF  	PORTD
		BTFSS 	STATUS,C
		GOTO 	CERO
		GOTO 	UNO


CERO	
		MOVLW 	D'0'
		MOVWF 	PORTE
		GOTO PRINCIPAL
		
		
UNO 
		MOVLW 	D'1'
		MOVWF 	PORTE
GOTO 	PRINCIPAL
		
	END                       ; directive 'end of program'

