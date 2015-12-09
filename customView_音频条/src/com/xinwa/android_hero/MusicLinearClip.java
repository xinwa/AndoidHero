package com.xinwa.android_hero;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class MusicLinearClip extends View {

	private int mWidth;
	private int mHeight;
	private int mCurrentHeight;
	private int mRectWidth;
	private int mRectCount = 6;
	private Paint mPaint;
	private LinearGradient linearGradient;
	private int offset = 8;//条形之间的间隔
	//如果view想要应用wrapContent，就必须重写onMeasure方法
	public MusicLinearClip(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mPaint = new Paint();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		mWidth = getWidth();
		mHeight = getHeight();
		System.out.println("width="+mWidth+",height="+mHeight);
		mRectWidth = (int) (mWidth*0.6/mRectCount);
		
		
		//他这个参数的意思是：既然是渐变的线，那么这个线是有宽度的，所以会有开始于结束的坐标
		linearGradient = new LinearGradient(
				0,
				0,
				mRectWidth,
				mHeight,
				Color.BLUE,
				Color.YELLOW,
				Shader.TileMode.CLAMP
				);
		
		mPaint.setShader(linearGradient);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		for (int i = 0; i < mRectCount; i++) {
			mCurrentHeight = (int)( Math.random()*mHeight);
		
			float left = (float) (mRectWidth*i+mWidth*0.2+offset);
			float top = mCurrentHeight;
			float right = (float) (mRectWidth*(i+1)+mWidth*0.2);
			float bottom = mHeight;
			//这里犯错的原因是我把他参数的意思给理解错了,left,top指得是左上角的横纵坐标，bottom,right指得是右下角的横纵坐标
			//他的坐标系箭头是向下的,当right的值小于left的值，bottom的值小于top的值时，这时候将不会绘制任何图形
			canvas.drawRect(left, top, right, bottom, mPaint);
		}

		postInvalidateDelayed(300);
	}
}
