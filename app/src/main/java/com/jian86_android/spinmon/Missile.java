package com.jian86_android.spinmon;

import android.graphics.Bitmap;

public class Missile {

    int width, height;

    Bitmap img;
    int x, y, rad; //중심좌표와 반지름(절반폭, 절반높이)
    boolean isDead= false;

    double radian; //이동각도(단위 radian)
    int speed;     //이동속도

    int angle;  //이미지의 회전각도(단위 몇도degrees)

    int kind; //미사일 종류

    public Missile(int width, int height, Bitmap[] imgMissile, int playerKind, int playerX, int playerY, int playerAngle) {
        this.width= width; this.height= height;
        //미사일 종류 == 플레이어의 종류
        kind= playerKind;

        x= playerX;
        y= playerY;

        img= imgMissile[kind];
        rad= img.getWidth()/2;//이미지의 절반사이즈

        //플레이어 이미지의 회전각도 == 미사일 이미지의 회전각도
        angle= playerAngle;

        //이동 각도
        radian= Math.toRadians(270-angle); //라디안 단위로 변환

        //이동 속도
        speed= rad/4;
    }

    void move(){

        x = (int)(x + Math.cos(radian)*speed);
        y = (int)(y - Math.sin(radian)*speed);

        //화면밖에 나가면 제거
        if( x<-rad || x>width+rad || y<-rad || y>height+rad){
            isDead=true;
        }

    }


}
