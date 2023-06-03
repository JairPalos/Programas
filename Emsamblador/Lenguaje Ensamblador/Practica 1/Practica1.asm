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



;***** VARIABLE DEFINITIONS
	CBLOCK 	0X20
		suma,resta,resultado
	ENDC

;**********************************************************************
	ORG     0x000             ; processor reset vector

	nop
  	goto    PORTS_CONFING              ; go to beginning of program



PORTS_CONFING

PRINCIPAL
	MOVLW D'50'
	MOVWF suma
	MOVLW D'100'
	ADDWF suma,0
	MOVWF resta
	MOVLW D'70'
	SUBWF resta,0
	MOVWF resultado
	
	GOTO PRINCIPAL
	
	
		    ;Comentarios
; remaining code goes 

	END                       ; directive 'end of program'

