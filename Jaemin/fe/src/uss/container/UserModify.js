import React, {useState, useEffect, useCallback} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'

const UserModify=(props)=>{

    const [update, setUpdate] = useState({})

    const {username, password, name, email, birthday, gender} = update;

    const Modify =e=>{
        e.preventDefault()
        axios.put(`http://localhost:8080/user/modify/${props.match.params.userId}`,{
            userNo : props.match.params.userId,
            username,
            password,
            name,
            email,
            birthday,
            gender
        })
        .then(res=>{
            console.log(res)
            setUpdate(res.data)
            localStorage.clear()
            localStorage.setItem("0", res.data)
            fetchOne()
            alert('회원 정보가 수정되었습니다.')
            props.history.push(`/UserRead/${props.match.params.userId}`)
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    const fetchOne=()=>{
        axios.get(`http://localhost:8080/user/read/${props.match.params.userId}`)
        .then(res=>{
            console.log(res)
            setUpdate(res.data)
            
        })
        .catch((err)=>{
            console.log(err)
        })
    }

    useEffect(()=>{
        fetchOne()
    }, [])

    const handleChange = useCallback(e=>{
        const{name, value} =e.target;
        setUpdate({...update,
            [name] : value})
    },[update])

    return(
        <form>
            <table>
                <thead>회원정보 수정</thead>
                <tbody>
                    <tr>
                        <th>아이디</th>
                        <td><input name='username' value={update.username} onChange={handleChange}readOnly></input></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type='password' placeholder='비밀번호 수정하세요' name='password' value={update.password} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input name='name' value={update.name} onChange={handleChange} readOnly></input></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type='text' placeholder='이메일을 수정하세요' name='email' value={update.email} onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><input name='birthday' value={update.birthday} onChange={handleChange} readOnly></input></td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>  <select name="gender" value={update.gender} onChange={handleChange}>
                                <option value="남성">남성</option>
                                <option value="여성">여성</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>
                            <input type='button' onClick={Modify} value='수정'/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div>
                <Link to={`/UserRead/${props.match.params.userId}`}><button>나가기</button></Link>
            </div>
        </form>
        )
}

export default UserModify