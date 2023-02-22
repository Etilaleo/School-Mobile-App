package com.example.esmmobile

data class LoginInfo(
    val password : String,
    val email : String,
    val matricNo : String,
    val username : String
)
{
    constructor() : this ("", "", "", "")
}
