
package com.spring.base.websocket.util;


public class AppConstant {
	
	public static enum YESORNO {
       // 利用构造函数传参
		YESORNO0("否"),YESORNO1("是") ;
 
       // 定义私有变量
       private String nCode ;
 
       // 构造函数，枚举类型只能为私有
       private YESORNO( String _nCode) {
           this . nCode = _nCode;
       }
 
       @Override
       public String toString() {
           return String.valueOf ( this . nCode );
       }
    }

	
}
