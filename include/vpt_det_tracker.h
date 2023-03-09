/*******************************************************************************************
* Version: wh_vpt_dt_version:0.0.2.20220821
* CopyRight: 
* UpdateDate: 20220821
* Content���˳��������
********************************************************************************************/
#ifndef VPTDETTRACK_H_
#define VPTDETTRACK_H_



#ifdef _MSC_VER
#ifdef VPTDETTRACK_EXPORTS
#define VPTDETTRACK_API __declspec(dllexport)
#else
#define VPTDETTRACK_API __declspec(dllimport)
#endif
#else
#define VPTDETTRACK_API __attribute__ ((visibility ("default")))
#include <stdlib.h>
#endif




#include <vector>
#include <iostream>
#include "vpt_head.h"

#ifdef __cplusplus
extern "C"
{
#endif


#ifndef VPTDETTRACK_PARAM
#define VPTDETTRACK_PARAM
typedef struct vptdt_param
{
	int gpuid;		//���п��� GPUģʽ����Ч
	float det_thre;	//�����ֵ Ĭ��Ϊ0.6
	int max_batchsize;//���batchsize������Ԥ�����Դ�
	
	int fusion_interval;		//1:ÿ֡����� 2����һ֡��� �Դ�����
	vptdt_param() : gpuid(0), det_thre(0.6), max_batchsize(10), fusion_interval(1) {};
}vptdt_param;
#endif

/*************************************************************************
* FUNCTION: vptdt_init
* PURPOSE: ��ʼ��
* PARAM:
[in] handle		 -������
[in] param		 -��ʼ������
* RETURN:	success(0) or error code(<0)
*************************************************************************/
VPTDETTRACK_API int vptdt_init(void **handle, vptdt_param param);

/*************************************************************************
* FUNCTION: vptdt_release
* PURPOSE: ��Դ�ͷ�
* PARAM:
[in] handle		- ������
* RETURN:	NULL
* NOTES:
*************************************************************************/
VPTDETTRACK_API void vptdt_release(void **handle);




/*************************************************************************
* FUNCTION: vptdt_process
* PURPOSE: �˳��������
* PARAM:
  [in] handle		- ������
  [in] rgb		    - ͼƬ���ݣ�3ͨ��BGR���� cv::Mat��ʽ��
  [in] width		- ͼƬ���
  [in] height		- ͼƬ�߶�
  [in] result		- �����ٽ��
* RETURN:	 ����(>= 0)�����(<0)
* NOTES:
*************************************************************************/
VPTDETTRACK_API int vptdt_process(void * handle,unsigned char * rgb, int width, int height, vptdt_result * result);
VPTDETTRACK_API int vptdt_process_batch(void * handle, xjs_batch_img *img_data_array,  int batchsize, vptdt_result * result);


/*************************************************************************
* FUNCTION: vptdt_get_version
* PURPOSE: ��ȡ�汾��
* PARAM:	NULL
* RETURN:	�汾��
* NOTES:
*************************************************************************/
VPTDETTRACK_API const char * vptdt_get_version();


#ifdef __cplusplus
};
#endif


#endif
