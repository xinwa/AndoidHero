package com.xinwa.android_hero;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView{

	private Paint mPaint1;
	private Paint mPaint2;
	private int mViewWidth;
	private int mTranslate;
	private Matrix mGradientMatrix;
	private LinearGradient linearGradient;
	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mPaint1 = new Paint();
		mPaint2 = new Paint();
		mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
		mPaint1.setStyle(Paint.Style.FILL);
		
		mPaint2.setColor(Color.YELLOW);
		mPaint2.setStyle(Paint.Style.FILL);
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		if(mViewWidth == 0){
			mViewWidth = getMeasuredWidth();
			if(mViewWidth > 0){
				Paint p = getPaint();
				linearGradient = new LinearGradient(0,
						0,
						mViewWidth,
						0,
						new int[]{Color.BLUE,0xffffff,Color.BLUE},
						null,
						Shader.TileMode.CLAMP);
				//shader 著色器，着色的程序
				p.setShader(linearGradient);
				mGradientMatrix = new Matrix();
			}
		}
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
		canvas.drawRect(10, 10, getMeasuredWidth()-10, getMeasuredHeight()-10, mPaint2);
		canvas.save();
//		canvas.translate(10, 0);
		//这里绘制图形，如果实在super.onDraw()方法之后，会覆盖在textView上面，将看不到文字的内容
		super.onDraw(canvas);
		canvas.restore();
		if(mGradientMatrix != null){
			mTranslate += mViewWidth/5;
			//这里的操作主要用于渐变色的循环，通过设置距离，来达到渐变色颜色变化的时间的间隙
			if(mTranslate > 2*mViewWidth){
				mTranslate = -mViewWidth;
			}
			mGradientMatrix.setTranslate(mTranslate, 0);
			linearGradient.setLocalMatrix(mGradientMatrix);
			postInvalidateDelayed(100);
		}
		
	}
}
