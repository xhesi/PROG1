for %x in (DateValidator_test*.in)  do (
 set a=%x 
 echo  /y %a% %a:DateValidator=Weekdays%
 )
 