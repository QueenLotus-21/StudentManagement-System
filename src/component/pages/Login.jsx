import React, { useRef, useState } from 'react'
import axios from '../layout/AxiosConfig';
import { Link, useNavigate } from 'react-router-dom';
import  "../layout/css/styled.css"

    
    export default function Login() {
        let navigate=useNavigate();
        const emailDom=useRef();
        const passwordDom=useRef();
        const [successMessage, setSuccessMessage] = useState('');
        const [errorMessage, setErrorMessage] = useState('');
    
        // const onInputChange=(e)=>{
        //     setUser({... user,[e.target.name]:e.target.value})
        // }
      async  function handleSubmit(e) {
        e.preventDefault();

         const emalValue=emailDom.current.value;
         const passwordValue=passwordDom.current.value;
         

         if (!emalValue || !passwordValue) {
            setErrorMessage("please provide all information");
            return;
        }

        try {
          const {data}=  await axios.post('/users/login',{
                email:emalValue,
                password:passwordValue
            });
           // alert("Successfully login")
           // alert(data?.message)
            console.log(data.success);
            //navigate('/')
            if((data.success) === true){
                setSuccessMessage("Successfully login")
                navigate('/')
            }
            else{
                setErrorMessage(data?.message)
            }
        } catch (error) {
            //console.log(error);
            setErrorMessage(error?.data?.message)
        }
            
        } 
    
 
    
      return (
        <div className='container'>
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded  mt-5 shadow">          
                   <div className='login p-2 mb-4' > <h2 className='text-center mb-4'>Login</h2></div>    
                    <form onSubmit={handleSubmit}>

                        <div className="mb-4 p-2">
                            <input 
                            type="email" 
                            className="form-control" 
                            placeholder='Enter your Email'
                            name='email'
                            ref={emailDom}
                            />
                        </div>
                 
    
                        <div className="mb-4">      
                            <input 
                            type="text" 
                            className="form-control" 
                            placeholder='Enter your Password'
                            name='password'
                            ref={passwordDom}                      
                            />
                        </div>
                        <div> If you are not register? <Link to={'/addUser'}>SignUp</Link>
                        </div>
    
                        <div className="text-center mt-2 pb-4">
                            <button type='submit' className="btn btn-outline-primary "> Login</button>
                            <Link className="btn btn-outline-danger mx-2" to="/"> Cancel</Link>
                        </div>
                   </form>  

                   <div className="response text-center p-4">
            {successMessage && (
            <div
                className="p-2"
                style={{
                color: "green",
                fontSize: "25px",
                background: "rgba(var(--bs-primary-rgb))",
                }}
            >
                {successMessage}
            </div>
            )}
            {errorMessage && (
            <div style={{ color: "red", fontSize: "35px" }}>{errorMessage}</div>
            )}
         </div>
                 
    
                </div>
            </div>
        </div>
      )
    }
    
