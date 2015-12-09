package com.xinwa.android_hero;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

	
	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
//		 super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
	}

	private int measureWidth(int widthMeasureSpec) {
		int result = 0;
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);

		if (widthSpecMode == MeasureSpec.EXACTLY) {
		    result = widthSize;
		}else{
			result = 200;//宽度的默认值
			result = Math.min(result, widthSize);
		}
		return result;
	}
	private int measureHeight(int heightMeasureSpec) {
		int result = 0;
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		if (heightSpecMode == MeasureSpec.EXACTLY) {
			result = heightSize;
		}else{
			result = 200;//高度的默认值
			result = Math.min(result, heightSize);
		}
		return result;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.BLACK);
		
	}

}
