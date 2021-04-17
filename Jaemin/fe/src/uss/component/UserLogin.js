import React, {useState, useCallback, useEffect} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'
import { Navbar, Nav, Form, FormControl, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
const UserLogin =(props)=>{
    const[login, setLogin] = useState("")
    const {username, password} = login
   
   
    const handleLogin = useCallback(e=>{
        const {name, value} = e.target;
        setLogin({...login, 
            [name] : value});
    }, [login])


    const loginOne = useCallback(e=>{
        e.preventDefault();
        axios.post(`http://localhost:8080/user/login`, {
          
          username,
          password
        })
                .then(res=>{
                    alert('로그인 됐습니다.')
                    console.log(res)
                    if(res.data){
                        localStorage.clear()
                        localStorage.setItem("0", res.data)
                        console.log(localStorage.getItem("0"))
                        props.history.push("/")
                    }
                })
                .catch(()=>{
                    alert('가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.')
                })
              
            },[username, password])
   

    return(
        <form onSubmit={loginOne} method="post">
            <table>
                <thead>Q&A게시판에 오신걸 환영합니다.</thead>
                <tbody>
                
                    <tr>
                        <th>아이디</th>
                        <td><input type='text' placeholder='아이디를 입력해주세요' name = 'username' value={login.username} onChange={handleLogin}/></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type='password' placeholder='비밀번호를 입력해주세요' name = 'password' value={login.password} onChange={handleLogin}/></td>
                    </tr>
                    <tr>
                        <td>
                            <button type='submit' onClick={()=>loginOne}>로그인</button>
                        </td>
                        <td>
                            <Link to={'/UserRegister'}><button>회원가입</button></Link>
                        </td>
                    </tr>
                    <Link to={'/'}><button>나가기</button></Link>
                </tbody>
            </table>
        </form>
        )
}

export default UserLogin