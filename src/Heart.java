import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heart extends javafx.scene.image.ImageView{

	Animation heartBreak;
	
	Image HEART_1 = new Image("file:heart_images/1.png");
	Image HEART_2 = new Image("file:heart_images/2.png");
	Image HEART_3 = new Image("file:heart_images/3.png");
	Image HEART_4 = new Image("file:heart_images/4.png");
	Image HEART_5 = new Image("file:heart_images/5.png");
	Image HEART_6 = new Image("file:heart_images/6.png");
	Image HEART_7 = new Image("file:heart_images/7.png");
	Image HEART_8 = new Image("file:heart_images/8.png");
	Image HEART_9 = new Image("file:heart_images/9.png");
	Image HEART_10 = new Image("file:heart_images/10.png");
	Image HEART_11 = new Image("file:heart_images/11.png");
	Image HEART_12 = new Image("file:heart_images/12.png");
	Image HEART_13 = new Image("file:heart_images/13.png");
	Image HEART_14 = new Image("file:heart_images/14.png");
	Image HEART_15 = new Image("file:heart_images/15.png");
	Image HEART_16 = new Image("file:heart_images/16.png");
	Image HEART_17 = new Image("file:heart_images/17.png");
	Image HEART_18 = new Image("file:heart_images/18.png");
	Image HEART_19 = new Image("file:heart_images/19.png");
	Image HEART_20 = new Image("file:heart_images/20.png");
	Image HEART_21 = new Image("file:heart_images/21.png");
	Image HEART_22 = new Image("file:heart_images/22.png");
	Image HEART_23 = new Image("file:heart_images/23.png");
	Image HEART_24 = new Image("file:heart_images/24.png");
	Image HEART_25 = new Image("file:heart_images/25.png");
	Image HEART_26 = new Image("file:heart_images/26.png");
	Image HEART_27 = new Image("file:heart_images/27.png");
	Image HEART_28 = new Image("file:heart_images/28.png");
	Image HEART_29 = new Image("file:heart_images/29.png");
	Image HEART_30 = new Image("file:heart_images/30.png");
	Image HEART_31 = new Image("file:heart_images/31.png");
	Image HEART_32 = new Image("file:heart_images/32.png");
	Image HEART_33 = new Image("file:heart_images/33.png");
	
	public Heart(PlayerWorld world) {
		setImage(HEART_1);

		heartBreak = new Animation(this, 500, HEART_1, HEART_2,HEART_3,HEART_4,HEART_5,HEART_6,HEART_7,HEART_8,HEART_1,HEART_9,HEART_10, HEART_10,HEART_11,HEART_12,HEART_13,HEART_14,HEART_15,HEART_16,HEART_17,HEART_18,HEART_19,HEART_20,HEART_21,HEART_22,HEART_23,HEART_24,HEART_25,HEART_26,HEART_27,HEART_28,HEART_29,HEART_30,HEART_31,HEART_32,HEART_33);
		heartBreak.setWorld(world);
	}

	
	public void crackHeart() {
		heartBreak.runAnimation();
	}


	
}
