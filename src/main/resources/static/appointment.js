console.log("appointment.js open")

const onDelete = async ( appointmentid ) => {
    console.log('onDelete....');
    const response = await axios.delete( `/hospital-management/appointment?appointmentid=${ appointmentid }` )
    if( response.data == true ){ onFindAll(); }
}

const onUpdate = async ( appointmentid ) => {
    console.log(`onUpdate.... ${appointmentid}`);

    const patientid = prompt('새로운 환자번호')
    const doctorid = prompt('새로운 의사번호')
    const appointmentdate = prompt('새로운 예약날짜')
    const appointmenttime = prompt('새로운 예약시간')
    const status = prompt('새로운 예약상태')

    const obj = { appointmentid , patientid , doctorid , appointmentdate , appointmenttime , status };
    console.log(obj)

    const response = await axios.put( '/hospital-management/appointment' , obj )
    if( response.data == true ){ onFindAll(); } // 만약에 응답 내용이 1 이면 수정 성공 -> 전체조회함수 실행
}

const onFindAll = async ( ) => {
    console.log('onFindAll...');
    try{
        const response = await axios.get( '/hospital-management/appointment' )
        console.log( response.data ); // response 응답(정보)객체 , response.data : 응답객체내 본문내용
        const tbody = document.querySelector('tbody')
        let html = ``
            response.data.forEach( appointment => {
                html += `<tr>
                            <td>${ appointment.appointmentid } </td>
                            <td>${ appointment.patientid }</td>
                            <td>${ appointment.doctorid }  </td>
                            <td>${ appointment.appointmentdate }  </td>
                            <td>${ appointment.appointmenttime }  </td>
                            <td>${ appointment.status }  </td>
                            <td>
                                <button onclick="onUpdate(${ appointment.appointmentid })"> 수정 </button>
                                <button onclick="onDelete(${ appointment.appointmentid })"> 삭제 </button>
                            </td>
                          </tr>`
            })
        tbody.innerHTML = html;
    }catch( e ){ console.log( e ); }
}

const onSave =  ( ) => {
    const patientid = document.querySelector('#patientid').value;
    const doctorid = document.querySelector('#doctorid').value;
    const appointmentdate = document.querySelector('#appointmentdate').value;
    const appointmenttime = document.querySelector('#appointmenttime').value;
    const status = document.querySelector('#status').value;

    const obj = { patientid , doctorid , appointmentdate , appointmenttime , status };
    console.log( obj );

    axios.post( '/hospital-management/appointment' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )
}

onFindAll();