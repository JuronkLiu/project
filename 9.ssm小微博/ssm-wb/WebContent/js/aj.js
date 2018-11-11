 function getXhr(){     
 	var xhr = null;      
 	//确保IE7,IE8，FireFox下可以运行        
 	if(window.XMLHttpRequest){       
 		xhr = new XMLHttpRequest();   
 	}else{         
 			//确保IE6可以运行，无视更古老的IE浏览器        
 	   xhr = new ActiveXObject("Microsoft.XMLHttp"); 
 	}       
 	return xhr;
 	//更简易的写法         //xhr = window.XMLHttpRequest?    
 	//new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");    }
 }