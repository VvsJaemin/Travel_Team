import React from 'react'
import QnaRegister from './qbs/container/QnaRegister'
import QnaList from './qbs/container/QnaList'
import QnaModify from './qbs/container/QnaModify'
import QnaRead from './qbs/container/QnaRead'
import { Route } from 'react-router-dom'
import UserRegister from './uss/container/UserRegister'
import UserLogin from './uss/container/UserLogin'
import UserList from './uss/container/UserList'
import UserRead from './uss/container/UserRead'
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
