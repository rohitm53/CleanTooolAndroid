package com.cleantool.indiacleantool.utils.animationutils

import android.graphics.Camera
import android.graphics.Matrix
import android.view.animation.Animation
import android.view.animation.Transformation

class Flip3dAnimation(val mFromDegrees :Float, val mToDegrees : Float, val mCenterX:Float,val mCenterY :Float) : Animation() {


    private lateinit var mCamera: Camera

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        mCamera = Camera()
        this.repeatCount=Animation.INFINITE
    }


    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)

        val fromDegress : Float = mFromDegrees
        val degress : Float = fromDegress +((mToDegrees-fromDegress)*interpolatedTime)

        val centerX = mCenterX
        val centerY = mCenterY
        val camera = mCamera

        camera.rotateY(degress)

        val matrix : Matrix? = t?.matrix

        camera.getMatrix(matrix)
        camera.restore()

        matrix?.preTranslate(-centerX,-centerY)
        matrix?.postTranslate(centerX,centerY)

    }

}