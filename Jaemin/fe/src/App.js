import React from 'react'
import { QnaRegister, QnaList, QnaModify, QnaRead} from 'qbs/index'
import {UserRegister, UserLogin, UserList, UserRead} from 'uss/index'
import { Route } from 'react-router-dom'
// import UserModify from './uss/container/UserModify'




const App =()=> {
  
  return(<>
    <Route path='/' component={QnaList} exact/>
    <Route path='/QnaRegister' component={QnaRegister}/>
    <Route path='/QnaList' component={QnaList}/>
    <Route path='/QnaModify/:Id' component={QnaModify}/>
    <Route path='/QnaRead/:id' component={QnaRead}/>
    <Route path='/UserRegister' component={UserRegister}/>
    <Route path='/UserLogin' component={UserLogin}/>
    <Route path='/UserList' component={UserList}/>
    <Route path='/UserRead/:username' component={UserRead}/>
    {/* <Route path ='/UserModify/:userId' component={UserModify}/> */}
  </>)

  }
 

export default App;
