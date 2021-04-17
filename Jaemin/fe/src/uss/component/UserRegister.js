import React, {useState, useCallback} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'

const UserRegister = (props) => {
    const [register, setRegister] = useState({})

    const {
        username,
        password,
        name,
        email,
        birthday,
        gender
    
    } = register

    const Register = e => {
        e.preventDefault()
        axios
            .post(`http://localhost:8080/user`, {
                username,
                password,
                name,
                email,
                birthday,
                gender
            })
            .then(res => {
                console.log(res)
                alert("회원가입을 해주셔서 감사합니다.")
                props
                    .history
                    .push('/')
            })
            .catch(() => {
                alert("양식에 맞게 입력해주세요")
            })
        }

    const handleSubmit = useCallback(e => {
        const {name, value} = e.target
        setRegister({
            ...register,
            [name]: value
        })
    }, [register])

    return (
        <form>
            <table>
                <thead>아래 양식에 맞게 회원 가입을 해주세요</thead>
                <tbody>
                    <tr>
                        <th>
                            아이디
                        </th>
                        <td><input
                            type='text'
                            placeholder='아이디를 입력(10자이내)'
                            name='username'
                            value={register.username}
                            onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <th>
                            비밀번호
                        </th>
                        <td><input
                            type='password'
                            placeholder='비밀번호를 입력하세요'
                            name='password'
                            value={register.password}
                            onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <th>
                            이름
                        </th>
                        <td><input
                            type='text'
                            name='name'
                            value={register.name}
                            onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <th>
                            이메일
                        </th>
                        <td><input
                            type='text'
                            placeholder='이메일을 입력하세요'
                            name='email'
                            value={register.email}
                            onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <th>
                            생년월일
                        </th>
                        <td><input
                            type='text'
                            placeholder='생년월일 입력하세요'
                            name='birthday'
                            value={register.birthday}
                            onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <th>
                            성별
                        </th>
                        <td>
                            <select name="gender" value={register.gender} onChange={handleSubmit}>
                                <option value="남성">남성</option>
                                <option value="여성">여성</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type='button' onClick={Register} value='등록'/>
                        </td>
                        <td>
                            <Link to="/QnaList">
                                <button>취소</button>
                            </Link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    )
}

export default UserRegister;