import React, { useEffect} from 'react'
import axios from 'axios'

const UserLogout =(props)=>{
   
    const onClickHandler=(e)=>{
        e.preventDefault();
        axios.get('http://localhost:8080/user/logout')
        .then(res=>{
            if(res.data.success){
                props.history.push('/')
            }else{
                console.log(res)
                alert("로그아웃에 실패")
            }
            })
    }

    useEffect(()=>{
        axios.get('http://localhost:8080/qna/list')
        .then(res=>{
            console.log(res.data)
        })
    }, [])

    return(
        
        <button onClick={onClickHandler}>로그아웃</button>

        )
}

export default UserLogout;