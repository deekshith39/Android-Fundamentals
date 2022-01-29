package com.example.passingdata

import java.io.Serializable

data class Person (
    val name: String,
    val age: Int,
    val country: String
): Serializable

// Serializable is mentioned so that it can easily transferred from one activity to another

