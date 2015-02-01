 
var myCalendar = null;
var func = null;
function init()
  {
	  initCalendar();
  }
 
 function initCalendar()
 {
	 myCalendar = new YAHOO.widget.Calendar("calendarContainer");
	 myCalendar.selectEvent.subscribe(getDate, myCalendar, true); 
	 myCalendar.render();
 }
 
 function fnSubmit() 
 {
	document.forms[0].submit();
 }
 
 function getDate() 
 { 
    var calDate = myCalendar.getSelectedDates()[0]; 
    date = (calDate.getMonth() + 1) + '/' + calDate.getDate() + '/' + calDate.getFullYear(); 
    if(func == 'deliveryDate')
    {
    	document.getElementById('deliveryDate').value = date;
    }
    else
    {
    	document.getElementById('patchDate').value = date;
    }
    hideCalendar(); 
} 
 
 function showCalendar(funcn)
 {
	 func = funcn;
	 var calImage = document.getElementById("calImage");
     var xy = YAHOO.util.Dom.getXY("calImage");
     xy[1] = xy[1] + 20; 
     YAHOO.util.Dom.setXY('calendarContainer', xy); 
     document.getElementById("calendarContainer").style.display = "block";
 }
 
 function hideCalendar()
 {
	 document.getElementById("calendarContainer").style.display = "none";
 }


