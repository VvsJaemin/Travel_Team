import React, {useEffect, useState, useCallback} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'

const UserRead=(props)=>{

    const [detail, setDetail] = useState({})

    const fetchOne = ()=>{

        axios.get(`http://localhost:8080/user/read/${props.match.params.userid}`)
        .then((res) => {
            console.log(res)
            setDetail(res.data)
        })
        .catch(err =>{
            console.log(err)
        } )
    }

    const deleteUser =()=>{
        if(window.confirm('정말 삭제하시겠습니까?'))
            axios.delete(`http://localhost:8080/user/delete/${props.match.params.userid}`)
            .then(res=>{
                console.log(res)
                alert('회원 탈퇴가 정상적으로 처리 됐습니다.')
                props.history.push('/UserList')
            } )
            .catch((err =>{
                console.log(err)
            } ))
    }

    useEffect(()=>{
        fetchOne()
    },[])

    return(

        <>
        <table>
            <thead>
                <tr>
                    <th>No</th>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>생년월일</th>
                    <th>성별</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{detail.userNo}</td>
                    <td>{detail.username}</td>
                    <td>{detail.name}</td>
                    <td>{detail.email}</td>
                    <td>{detail.birthday}</td>
                    <td>{detail.gender}</td>
                </tr>
            </tbody>
        </table>
        <div>
            <Link to={`/UserModify/${detail.userNo}`}>
                <button>수정하기</button>
            </Link>
        </div>
        <div>
        <button onClick={deleteUser}>삭제하기</button>
        <td>
            <Link to='/'><button>나가기</button></Link>
        </td>
        </div>
        </>
        )
}

export default UserRead;