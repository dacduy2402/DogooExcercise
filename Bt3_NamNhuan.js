function leapYear(year){
    if (year % 4 == 0) {
        if(year % 100 == 0){
            if(year % 400 == 0){
                console.log('Năm ' + year + ' là năm nhuận');
            }
            else{
                console.log('Không là năm nhuận');
            }           
        }
        else{
            console.log('Năm ' + year + ' là năm nhuận');
        }
    }
    else{
        console.log('Không là năm nhuận');
    }
}
leapYear(2004)
