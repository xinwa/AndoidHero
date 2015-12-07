package com.xinwa.android_hero;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTopBar extends RelativeLayout{
	public static  final int LEFT = 0;
	public static  final int RIGHT = 1;
	
	private String title;
	private int titleSize;
	private int titleColor;
	
	private String leftText;
	private int leftTextSize;
	private Drawable leftBackground;
	
	private String rightText;
	private int rightTextSize;
	private Drawable rightBackground;
	
	private TextView titleText;
	private TextView leftButton;
	private TextView rightButton;
	
	private LayoutParams titleParams;
	private LayoutParams leftParams;
	private LayoutParams rightParams;
	
	private OnTopBarClickListener topBarListener;
	public MyTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		//当你在xml布局文件中填写属性时，他会动态查找这个类中的相对应的属性来匹配类型
		TypedArray typeArray = getResources().obtainAttributes(attrs, R.styleable.TopBar);
		
		title = typeArray.getString(R.styleable.TopBar_title);
		titleSize = (int) typeArray.getDimension(R.styleable.TopBar_titleSize, 0);
		titleColor= typeArray.getColor(R.styleable.TopBar_titleColor,Color.WHITE);
		
		leftText = typeArray.getString(R.styleable.TopBar_leftText);
		leftTextSize = (int) typeArray.getDimension(R.styleable.TopBar_leftTextSize, 0);
		leftBackground = typeArray.getDrawable(R.styleable.TopBar_leftBackground);
		
		rightText = typeArray.getString(R.styleable.TopBar_rightText);
		rightTextSize = (int) typeArray.getDimension(R.styleable.TopBar_rightTextSize, 0);
		rightBackground = typeArray.getDrawable(R.styleable.TopBar_rightBackground);
		
		titleText = new TextView(context);
		leftButton = new TextView(context);
		rightButton = new TextView(context);
		
		titleText.setText(title);
		titleText.setTextSize(titleSize);
		titleText.setTextColor(titleColor);
		
		leftButton.setText(leftText);
		leftButton.setTextSize(leftTextSize);
		leftButton.setBackground(leftBackground);
		
		rightButton.setText(rightText);
		rightButton.setTextSize(rightTextSize);
		rightButton.setBackground(rightBackground);
		
		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		
		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		
		typeArray.recycle();
		
		addView(titleText, titleParams);
		addView(leftButton, leftParams);
		addView(rightButton, rightParams);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				topBarListener.leftClick();
			}
		});
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				topBarListener.rightClick();
			}
		});
	}
	

	
	public interface OnTopBarClickListener{
		void leftClick();
		void rightClick();
	}
	public void setOnTopBarClickListener(OnTopBarClickListener topBarListener){
		this.topBarListener = topBarListener;
	}
	
	public void setBtnVisible(int id,boolean flag){
		if(id == LEFT){
			if(flag){
				leftButton.setVisibility(View.VISIBLE);
			}else{
				leftButton.setVisibility(View.GONE);
			}
		}else{
			if(flag){
				rightButton.setVisibility(View.VISIBLE);
			}else{
				rightButton.setVisibility(View.GONE);
			}
		}
	}
}
