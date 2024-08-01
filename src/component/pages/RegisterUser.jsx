import React, { useState } from 'react'
import axios from '../layout/AxiosConfig';
import { Link, useNavigate } from 'react-router-dom';
import "../layout/css/styled.css"

export default function RegisterUser() {
    let navigate=useNavigate();

    const [user,setUser]=useState({
        fullname:"",
        email:"",
        phone:"",
        password:""
    })
    const{fullname,email,phone,password}=user;

    const onInputChange=(e)=>{
        setUser({... user,[e.target.name]:e.target.value})
    }
    const onSubmit=async (e)=> {
        e.preventDefault();
        try {
            await axios.post("/users/register",user);
            alert("user Successfully registerd")
            navigate('/')
            
        } catch (error) {
            console.log(error)
        }

        
    }


  return (
    <div className='container'>
        <div className="row">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-5 shadow">
            <div className='register p-2 mb-4' > <h2 className='text-center mb-4'>SignUp</h2></div>  

                <form onSubmit={(e)=>onSubmit(e)}>
                    <div className="mb-4">
                    {/* <label htmlFor="Name" className=' form-label '>
                            Name
                    </label> */}
                        <input 
                        type="text" 
                        className="form-control" 
                        placeholder='Enter your Name'
                        name='fullname'
                        value={fullname}
                        onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-4">
                        <input 
                        type="email" 
                        className="form-control" 
                        placeholder='Enter your Email'
                        name='email'
                        value={email}
                        onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="mb-4">
                        <input 
                        type="text" 
                        className="form-control" 
                        placeholder='Enter your Phone'
                        name='phone'
                        value={phone}
                        onChange={(e)=>onInputChange(e)}
                        />
                        
                    </div>

                    <div className="mb-4">
                        <input 
                        type="text" 
                        className="form-control" 
                        placeholder='Enter your Password'
                        name='password'
                        value={password}
                        onChange={(e)=>onInputChange(e)}
                        />
                    </div>

                    <div className="text-center mt-2">
                        <button type='submit' className="btn btn-outline-primary "> Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/"> Cancel</Link>
                    </div>
               </form>  

            </div>
        </div>
    </div>
  )
}
