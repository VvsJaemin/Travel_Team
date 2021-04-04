import React, {useState, useEffect, useCallback} from 'react'
import axios from 'axios'

const UserLogout = (props) => {
    const [logout, setLogout] = useState("")
    const {username, password} = logout


    const LogoutHandler = useCallback(e => {
        e.preventDefault();
        axios
            .get('http://localhost:8080/user/logout', {username, password})
            .then(res => {
                if (res) {
                    sessionStorage.setItem('username', '/UserLogin.username')
                    sessionStorage.setItem('password', password)
                    console.log(
                        res.data,
                        "storage : ",
                        sessionStorage.getItem('username'),
                        sessionStorage.getItem('password')
                    )
                    setLogout(res)
                    props
                        .history
                        .push('/')
                } else {
                    console.log(res)
                    alert("로그아웃에 실패")
                }
            })
            .catch((err) => {
                alert('다시 시도해주세요')
            })

        }, [username, password])

    useEffect(() => {
        axios
            .get('http://localhost:8080/qna/list')
            .then(res => {
                console.log(res.data)
            })
    }, [])

    return (<button onClick={LogoutHandler}>로그아웃</button>)
}

export default UserLogout;