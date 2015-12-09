package com.xinwa.android_hero;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

public class SweepView extends View {
	/** 圆心得坐标 */
	private int mCircleXY;
	/**外层圈子的宽度*/
	private int circleWidth;
	private int radius;
	private RectF mArcRectF;
	private Paint textPaint;
	private Paint arcPaint;
	private Paint circlePaint;
	private String mShowText = "show skills";
	
	/** 滑过的角度 */
	private int sweepAngle = 270;
	/**圈子里面文字的大小*/
	private int circleTextColor;
	/**圆圈的背景颜色*/
	private int circleBackground;
	/**圆圈的文字大小*/
	private int circleTextSize;
	public SweepView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		TypedArray typeArray = context.getResources().obtainAttributes(attrs, R.styleable.CircleView);
		circleWidth = (int) typeArray.getDimension(R.styleable.CircleView_circleWidth, 200);
		circleBackground = typeArray.getColor(R.styleable.CircleView_circleBackground,Color.BLUE);
		circleTextColor = typeArray.getColor(R.styleable.CircleView_circleTextColor,Color.YELLOW);
		circleTextSize = circleBackground = (int) typeArray.getDimension(R.styleable.CircleView_circleTextSize, 30);
		
		mCircleXY = circleWidth / 2;
		radius = circleWidth / 4;
		mArcRectF = new RectF((float) (circleWidth * 0.15),
				(float) (circleWidth * 0.15), 
				(float) (circleWidth * 0.85),
				(float) (circleWidth * 0.85));
		
		textPaint = new Paint();
		textPaint.setColor(circleTextColor);
		textPaint.setTextSize(circleTextSize);
		textPaint.setTextAlign(Paint.Align.CENTER);
		
		arcPaint = new Paint();
		arcPaint.setStyle(Paint.Style.STROKE);
		arcPaint.setColor(Color.YELLOW);
		arcPaint.setStrokeWidth(45);
		
		circlePaint = new Paint();
		circlePaint.setColor(Color.BLUE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	
		canvas.drawArc(mArcRectF, 270, sweepAngle, false, arcPaint);
		canvas.drawCircle(mCircleXY, mCircleXY, radius, circlePaint);

		textPaint.measureText(mShowText, 0, mShowText.length());

		float baseLine = (circleWidth / 2)
				- ((textPaint.descent() + textPaint.ascent()) / 2);

		canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, baseLine,
				textPaint);
	}

	public void setSweepAngle(int sweepAngle){
		this.sweepAngle = sweepAngle;
		postInvalidate();
	}
}
