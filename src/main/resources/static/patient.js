console.log("patient.js open")

const onDelete = async ( patientid ) => {
    console.log('onDelete....');
    const response = await axios.delete( `/hospital-management/patient?patientid=${ patientid }` )
    if( response.data == true ){ onFindAll(); }
}

const onUpdate = async ( patientid ) => {
    console.log(`onUpdate.... ${patientid}`);

    const name = prompt('새로운 이름')
    const birthdate = prompt('새로운 생일')
    const phone = prompt('새로운 전화번호')
    const address = prompt('새로운 주소')

    const obj = { patientid , name , birthdate , phone , address };
    console.log(obj)

    const response = await axios.put( '/hospital-management/patient' , obj )
    if( response.data == true ){ onFindAll(); } // 만약에 응답 내용이 1 이면 수정 성공 -> 전체조회함수 실행
}

const onFindAll = async ( ) => {
    console.log('onFileAll...');
    try{
        const response = await axios.get( '/hospital-management/patient' )
        console.log( response.data ); // response 응답(정보)객체 , response.data : 응답객체내 본문내용
        const tbody = document.querySelector('tbody')
        let html = ``
            response.data.forEach( patient => {
                html += `<tr>
                            <td>${ patient.patientid } </td>
                            <td><a link="#" onclick="javascript:onView(${patient.patientid})" style="color: blue; text-decoration: underline; cursor: pointer;">${ patient.name }</a></td>
                            <td>${ patient.birthdate }  </td>
                            <td>${ patient.phone }  </td>
                            <td>${ patient.address }  </td>
                            <td>
                                <button onclick="onUpdate(${ patient.patientid })"> 수정 </button>
                                <button onclick="onDelete(${ patient.patientid })"> 삭제 </button>
                            </td>
                          </tr>`
            })
        tbody.innerHTML = html;
    }catch( e ){ console.log( e ); }
}

const onView = async (patientid) => {
    console.log(`onView... ${patientid}`);
    try{
        const nameElement = document.querySelector('#view-name');
        const birthdateElement = document.querySelector('#view-birthdate');
        const phoneElement = document.querySelector('#view-phone');
        const addressElement = document.querySelector('#view-address');

        const response = await axios.get( `/hospital-management/patient/view?patientid=${patientid}` )
        console.log( response.data );

        nameElement.innerHTML = `${response.data.name}`;
        birthdateElement.innerHTML = `${response.data.birthdate}`;
        phoneElement.innerHTML = `${response.data.phone}`;
        addressElement.innerHTML = `${response.data.address}`;

    }catch( e ){ console.log( e ); }
}

const onSave =  ( ) => {
    const name = document.querySelector('#name').value;
    const birthdate = document.querySelector('#birthdate').value;
    const phone = document.querySelector('#phone').value;
    const address = document.querySelector('#address').value;

    const obj = { name , birthdate , phone , address };
    console.log( obj );

    axios.post( '/hospital-management/patient' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )
}

onFindAll();