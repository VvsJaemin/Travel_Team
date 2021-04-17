import React, {useEffect, useState, useCallback} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'

const UserList = () => {

    const [users, setUsers] = useState([])

    const fetchUsers = () => {
        axios
            .get(`http://localhost:8080/user/list`)
            .then(res => {
                console.log(res)
                setUsers(...users, res.data)
            })
            .catch(err => {
                alert(err)
            })
        };

    useEffect(() => {
        fetchUsers()
    }, [])

    return (
        <> < table > <thead>
            <tr>
                <td>No</td>
                <td>아이디</td>
                <td>이름</td>
                <td>이메일</td>
                <td>생년월일</td>
                <td>성별</td>
                <td>상세정보</td>
            </tr>
        </thead>
        <tbody>
            {
                users.map((user) => {
                    const {
                        userNo,
                        username,
                        name,
                        email,
                        birthday,
                        gender
                    } = user
                    return (
                        <tr key={userNo}>
                            <td>{userNo}</td>
                            <td>{username}</td>
                            <td>{name}</td>
                            <td>{email}</td>
                            <td>{birthday}</td>
                            <td>{gender}</td>
                            <td>
            <Link to={`UserRead/${user.userNo}`}>
                <button>자세히읽기</button>
            </Link>
        </td>
                        </tr>
                    )
                })
            }
        </tbody>
    </table><br/>
    <Link to={'/'}>
        <button>나가기</button>
    </Link>
</>
    )
}

export default UserList