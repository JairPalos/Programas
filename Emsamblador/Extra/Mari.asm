;**********************************************************************
;                                                                     *
;    Filename:	    xxx.asm                                           *
;    Date:                                                            *
;    File Version:                                                    *
;                                                                     *
;    Author: Jair Antonio Palos Hernandez                        *
;    Company: Centro Universitario UAEM Zumpango                      *
;                                                                     *
;                                                                     *
;**********************************************************************
;                                                                     *
;    Notes:  Desplegar un mensaje en 2 lineas de manera que se        *
;		 	 desplace de izquierda a derecha y/o derecha a            *
;			 izquierda. Ademas hay que emplearse la directiva DT      *
;                                                                     *
;**********************************************************************

	list		p=16f887		; list directive to define processor
	#include	<p16f887.inc>	; processor specific variable definitions

	__CONFIG    _CONFIG1, _LVP_OFF & _FCMEN_ON & _IESO_OFF & _BOR_OFF & _CPD_OFF & _CP_OFF & _MCLRE_ON & _PWRTE_ON & _WDT_OFF & _INTRC_OSC_NOCLKOUT
	__CONFIG    _CONFIG2, _WRT_OFF & _BOR21V

;***** VARIABLE DEFINITIONS
	CBLOCK		0X020
				CTR1, CTR2, CTR3				; VARIABLES DE RETARDO
				CONT, CONT2
	ENDC

	#DEFINE		RS	PORTA,0		; DEFINIMOS AL PIN 0 DEL PUERTO A COMO RS
	#DEFINE		RW	PORTA,1		; DEFINIMOS AL PIN 1 DEL PUERTO A COMO RW
	#DEFINE		E	PORTA,2		; DEFINIMOS AL PIN 2 DEL PUERTO A COMO E
	

;**********************************************************************
	ORG     	0x00			; DIRECTIVA DE RESETEO DEL PROGRAMA
  	GOTO    	PORTS_CONFIG  	; SE VA A RUTINA PORTS_CONFIG (INICIO DEL PROGRAMA)
	
PORTS_CONFIG:
	BSF 		STATUS,RP0		; ACCESO AL BANCO 1 PARA REGISTROS
	BCF 		STATUS,RP1		; TRISA Y TRISB
	CLRF 		TRISA          	; PINES RB0:RB7 COMO SALIDAS DEL PUERTO A
	CLRF		TRISB 			; PINES RB0:RB7 COMO SALIDAS DEL PUERTO B
	
	BSF 		STATUS,RP0
	BSF 		STATUS,RP1		; 
	CLRF		ANSEL			; 
	CLRF		ANSELH			; 

	BCF 		STATUS,RP0		; ACCESO AL BANCO 0, PARA REGISTROS
	BCF 		STATUS,RP1		; PORTA Y PORTB
	CLRF 		PORTA           ; INICIALIZAR EN 0 LOS REGISTROS DE    
	CLRF 		PORTB           ; PORTA Y PORTB 


INICIALIZAR_LCD:
	MOVLW		0X38			; MANDAMOS 0X38 PARA TRABJAR CON LAS DOS LINEAS
	CALL		COMANDO			; Y LA MATRIZ DE 5X7 DE CADA LETRA
	MOVLW		0X0C			; MANDAMOS 0X0C PARA PRENDER EL DISPLAY CON
	CALL		COMANDO			; EL CURSOR APAGADO
	MOVLW		0X01			; MANDAMOS 0X01 PARA LIMPIAR LA PANTALLA DE
	CALL		COMANDO			; VISUALIZACION


;*********************************
;    MENSAJE PARA EL DISPLAY     *
;*********************************
REINICIO:
	CLRF		CONT
;************************************************************************************************************
VISUALIZAR:
	CALL		RETARDO		;Llama a  retardo
	MOVLW		0X8F		;Le pasa el valor de 8 al acumulador
	ADDWF		CONT,0		;Pasa el valor de el contador al acumuluador
	CALL		COMANDO		;Llama a la etiqueta comando
	MOVF		CONT,0		;Vueleve a pasar el valor al acumulador
	CALL 		TABLA		;LLAMA  a la tabla
	CALL		DATO		;Llama a dato

	MOVLW		0XCF		;Le pasa al acumulador el valor c
	ADDWF		CONT,0		;Le pasa el valor del contador hasta el acumulador
	CALL		COMANDO		;Llama a la rtiqueta contador
	MOVF		CONT,0		;Le pasa el valor del contador al acumulador
	CALL 		TABLA2		;Llama a la etiqueta tabala2
	CALL		DATO		;Vuelve a llamar a datp

	MOVLW		0X18		; MANDAMOS 0X01 PARA LIMPIAR LA PANTALLA DE
	CALL 		COMANDO		;Llama la etiqueta Comando
	
	INCF		CONT,1		;Incrementa el contador en 1
	MOVLW		D'21'		;Le pasa el valor de 15 como limite de letras
	XORWF		CONT,0		;Hace que el contador este en cero
	BTFSS		STATUS,Z	;Si el valor de z Esta en uno
		GOTO	VISUALIZAR	;si esta en uno lo manda a visualizar
		GOTO 	REINICIO	;si no lo manda a reinicio
;*******************************************************************************************************
;								TABLAS
TABLA:
	ADDWF		PCL,1				; Añade el valor del contador a al puerto
	DT			"Te extraño mucho amor"	;Mensaje a enviar en la primera fila
TABLA2:								;Inicia la tabla dos o fila dos
	ADDWF		PCL,1				;Incrementa el valor a la tabla
	DT			"Te quiero muchisimo  "	;Segundo valor del mensaje


;**********************************************************************************

COMANDO:					;Etiqueta Comando
	BCF			RS			;pone en 1 el RS
	BCF			RW			;pone en 1 el RW
	GOTO		CARGA_BUS	;Carga el bus
;**************************************************************************************+
DATO:
	BSF			RS			;pone en 0 la 
	BCF			RW			;pone en 0 la
	GOTO		CARGA_BUS	;se va a CARGA_BUS
;*************************************************************************************************
CARGA_BUS:
	MOVWF 		PORTB       ;
	BSF			E0
	CALL 		RETARDO_DP
	BCF			E
	CALL 		RETARDO_DP
	RETURN


;********************************************************************************************
RETARDO:
	MOVLW		0X35
	GOTO		RET

RETARDO2:
	MOVLW		0X15
	GOTO		RET


RETARDO_DP:
	MOVLW		0X08

RET:
	MOVWF		CTR3
L3:
	MOVWF		CTR2
L2:	
	MOVWF		CTR1
L1:
	DECFSZ		CTR1
	GOTO 		L1
	DECFSZ		CTR2
	GOTO 		L2
	DECFSZ		CTR3
	GOTO 		L3
	RETURN
FIN:
END         	            ; Directive 'end of program'



