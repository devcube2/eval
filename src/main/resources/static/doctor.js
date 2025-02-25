console.log("doctor.js open")

const onDelete = async ( doctorid ) => {
    console.log('onDelete....');
    const response = await axios.delete( `/hospital-management/doctor?doctorid=${ doctorid }` )
    if( response.data == true ){ onFindAll(); }
}

const onUpdate = async ( doctorid ) => {
    console.log(`onUpdate.... ${doctorid}`);

    const name = prompt('새로운 이름')
    const specialty = prompt('새로운 전문의학과')
    const phone = prompt('새로운 전화번호')

    const obj = { doctorid , name , specialty , phone };
    console.log(obj)

    const response = await axios.put( '/hospital-management/doctor' , obj )
    if( response.data == true ){ onFindAll(); } // 만약에 응답 내용이 1 이면 수정 성공 -> 전체조회함수 실행
}

const onFindAll = async ( ) => {
    console.log('onFindAll...');
    try{
        const response = await axios.get( '/hospital-management/doctor' )
        console.log( response.data ); // response 응답(정보)객체 , response.data : 응답객체내 본문내용
        const tbody = document.querySelector('tbody')
        let html = ``
            response.data.forEach( doctor => {
                html += `<tr>
                            <td>${ doctor.doctorid } </td>
                            <td><a link="#" onclick="javascript:onView(${doctor.doctorid})" style="color: blue; text-decoration: underline; cursor: pointer;">${ doctor.name }</a></td>
                            <td>${ doctor.specialty }  </td>
                            <td>${ doctor.phone }  </td>
                            <td>
                                <button onclick="onUpdate(${ doctor.doctorid })"> 수정 </button>
                                <button onclick="onDelete(${ doctor.doctorid })"> 삭제 </button>
                            </td>
                          </tr>`
            })
        tbody.innerHTML = html;
    }catch( e ){ console.log( e ); }
}

const onView = async (doctorid) => {
    console.log(`onView... ${doctorid}`);
    try{
        const nameElement = document.querySelector('#view-name');
        const specialityElement = document.querySelector('#view-speciality');
        const phoneElement = document.querySelector('#view-phone');

        const response = await axios.get( `/hospital-management/doctor/view?doctorid=${doctorid}` )
        console.log( response.data );

        nameElement.innerHTML = `${response.data.name}`;
        specialityElement.innerHTML = `${response.data.specialty}`;
        phoneElement.innerHTML = `${response.data.phone}`;

    }catch( e ){ console.log( e ); }
}

const onSave =  ( ) => {
    const name = document.querySelector('#name').value;
    const specialty = document.querySelector('#speciality').value;
    const phone = document.querySelector('#phone').value;

    const obj = { name , specialty , phone };
    console.log( obj );

    axios.post( '/hospital-management/doctor' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )
}

onFindAll();