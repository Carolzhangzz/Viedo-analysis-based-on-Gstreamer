#include <stddef.h>


//��batch��ʹ��
#ifndef __XJS_IMG__
#define __XJS_IMG__
typedef struct xjs_batch_img
{
	int w_;
	int h_;
	int c_;
	unsigned char * data_;
	//std::string video_key_;
	const char* video_key_; 
	long frameCount_; //��ʱû���õ�
	void set_data(int m_w, int m_h, int m_c, unsigned char * m_data, const char* m_video_key, long fcnt_)
	{
		w_ = m_w;
		h_ = m_h;
		c_ = m_c;
		data_ = m_data;
		video_key_ = m_video_key;
		frameCount_ = fcnt_;
	}
} xjs_batch_img;
#endif


//---------------- �˳���ǹ����������ṹ�嶨�� ------------------//
#define MAX_OBJ_COUNT 100


//Rect
#ifndef __SY_RECT__
#define __SY_RECT__
typedef struct sy_rect
{
	int left_;
	int top_;
	int width_;
	int height_;
	sy_rect(int m_left, int m_top, int m_width, int m_height) :left_(m_left), top_(m_top), width_(m_width), height_(m_height) {};
	sy_rect() {};
} sy_rect;
#endif


#ifndef VD_RESULT_
#define VD_RESULT_
typedef struct vd_result
{
	sy_rect rect;
	float score;
}vd_result;
#endif

#ifndef VPTDT_INFO
#define VPTDT_INFO
typedef struct vptdt_info	//����ṹ��
{
	int left;
	int top;
	int right;
	int bottom;
	int center_x;			//Ŀ������ĵ�x
	int center_y; 			//Ŀ������ĵ�y
	int id;					//	Ŀ��ΨһID��ͬһIDΪͬһĿ��
	double confidence;		//	���Ŷ�
	int index;              //�˳���9������0-person 1-bike 2-motor 3- tricycle 4-car 5-bigbus 6-lorry���� 7-tractor 8-midibus	
							//�ǹ�������0-ռ����Ӫ 1-�����Ҿ� 2-����С�� 3-��¶���� 4-�������� 5-�ؽ���ɹ 6-������� 7-���϶ѷ�

	//���Ŀ����������Խ��(�糵��������Ϣ���߲˹Ϲ�����)
	vd_result w_res;
	vd_result b_res;	
}vptdt_info;
#endif


#ifndef VPTDT_RESULT
#define VPTDT_RESULT
typedef struct vptdt_result
{
	vptdt_info objinfo[MAX_OBJ_COUNT];
	int objcount;
}vptdt_result;
#endif


