import React, {useEffect, useState, useCallback} from 'react'
import {Link, useHistory} from 'react-router-dom';
import axios from 'axios'

const UserRead=(props)=>{
    const [detail, setDetail] = useState({})

    const fetchOne = ()=>{

        axios.get(`http://localhost:8080/user/read/${props.match.params.username}`)
        .then(res => {
            console.log(res)
            setDetail(res.data)
           
        })
        .catch(err =>{
            console.log(err)
        } )
    }

    const Modify =()=>{
        
        axios.put(`http://localhost:8080/user/modify/${props.match.params.username}`,detail) 
        .then(res=>{
            console.log(res.data)
            setDetail(res.data)
            alert('회원 정보가 수정되었습니다.')
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    const deleteUser =()=>{
        
        if(window.confirm('정말 삭제하시겠습니까?'))
            axios.delete(`http://localhost:8080/user/delete/${props.match.params.username}`)
            .then(res=>{
                console.log(res)
                localStorage.clear() // 
                alert('회원 탈퇴가 정상적으로 처리 됐습니다.')
                props.history.push("/")
            })
            .catch(err =>{
                console.log(err)
            })
    }
    
    useEffect(()=> {
        fetchOne()
    }, [])

    const handleChange = useCallback(e=>{
        const{name, value} =e.target;
        setDetail({...detail,
            [name] : value})
    },[detail])
        
    return(

        <>
          <form onSubmit={ e => e.preventDefault() }>
            <table>
                <thead>회원정보 수정</thead>
                <tbody>
                    <tr>
                        <th>아이디</th>
                        <td><input name='username' value={detail.username} onChange={handleChange}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type='password' placeholder='비밀번호 수정하세요' name='password' value={detail.password} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input name='name' value={detail.name} onChange={handleChange} readOnly></input></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type='text' placeholder='이메일을 수정하세요' name='email' value={detail.email} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><input name='birthday' value={detail.birthday} onChange={handleChange} readOnly></input></td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>  <select name="gender" value={detail.gender} onChange={handleChange}>
                                <option value="남성">남성</option>
                                <option value="여성">여성</option>
                            </select></td>
                    </tr>
            </tbody>
        </table>
        <div>
        <button onClick={deleteUser}>삭제하기</button>
        <button type="submit" onClick={Modify}>변경하기</button>
        <td>
            <Link to='/'><button>나가기</button></Link>
        </td>
        </div>
        </form>
        </>
        )
}

export default UserRead;