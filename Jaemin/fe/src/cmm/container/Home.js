import React from 'react'
import { Link } from 'react-router-dom'

const Home =()=>{
    return(<>
    <div style={{width: 150, margin: "0 auto"}}><h1>Home</h1>
    <Link to={"QnaRegister"}>QnaRegister</Link><br/>
    <Link to={"QnaList"}>QnaList</Link><br/>
    <Link to={"QnaRead"}>QnaRead</Link>
    </div>
    </>)
}

export default Home;