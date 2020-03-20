package com.example.Project_60160094

class flower(var name: String, var score: Float) {
    companion object {
        fun getSampleStudentData(size: Int): ArrayList<flower> {
            val student: ArrayList<flower> = ArrayList()
            for (i in 0 until size) {
                student.add(flower("Flower $i", Math.random().toFloat() * 10))
            }
            return student
        }
    }

}