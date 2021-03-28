import React, {useState} from 'react'
import QnaRegister from './qbs/container/QnaRegister'
import QnaList from './qbs/container/QnaList'
import { Route } from 'react-router-dom'
import Home from './cmm/container/Home'


const App =()=> {
  
  return(<>
    <Route path='/' component={Home} exact/>
    <Route path='/QnaRegister' component={QnaRegister}/>
    <Route path='/QnaList' component={QnaList}/>

  </>)

  }
 

export default App;
