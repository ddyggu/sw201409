package co.kr.samwoospace.dao;

import java.util.List;


import java.util.Map;

import co.kr.samwoospace.bean.BoardRecord;
import co.kr.samwoospace.bean.ClubRecord;
import co.kr.samwoospace.bean.ConsultRecord;
import co.kr.samwoospace.bean.FaqRecord;
import co.kr.samwoospace.bean.PopupRecord;
import co.kr.samwoospace.bean.RecruitRecord;
import co.kr.samwoospace.bean.ResultRecord;
import co.kr.samwoospace.bean.TechRecord;
import co.kr.samwoospace.util.Paging;

public interface boardDAO {
	int selectLastId();

	Paging selectPagingInfo(String bbsId);
	List<BoardRecord> selectListBoardRecord(Paging paging);
	List<RecruitRecord> selectListRecruitRecord(Paging paging);
	List<ConsultRecord> selectListConsultRecord(Paging paging);
	List<FaqRecord> selectListFaqRecord(Paging paging);
	List<ClubRecord> selectListClubRecord(Paging paging);
	List<PopupRecord> selectListPopupRecord(Paging paging);
	List<TechRecord> selectListTechRecord(Paging paging);
	List<ResultRecord> selectListResultRecord(Paging paging);
	List<ResultRecord> selectListResultRecordByDivision(Map<String,Object> hashMap);
	
	List<RecruitRecord> selectListRecruitRecord(int pageNum);
	
	
	BoardRecord selectOneBoardRecord(int num);
	RecruitRecord selectOneRecruitRecord(int num);
	FaqRecord selectOneFaqRecord(int num);
	ConsultRecord selectOneConsultRecord(int num);
	ClubRecord selectOneClubRecord(int num);
	PopupRecord selectOnePopupRecord(int num);
	TechRecord selectOneTechRecord(int num);
	ResultRecord selectOneResultRecord(int num);
	
	int selectTotalCount(Paging paging);
	int selectTotalCountResult(Map<String,Object> paramMap);
	
	void insertBoardRecord(BoardRecord boardRecord);
	void insertRecruitRecord(RecruitRecord recruitRecord);
	void insertConsultRecord(ConsultRecord consultRecord);
	void insertClubRecord(ClubRecord clubRecord);
	void insertPopupRecord(PopupRecord popupRecord);
	void insertFaqRecord(FaqRecord faqRecord);
	void insertTechRecord(TechRecord techRecord);
	void insertResultRecord(ResultRecord resultRecord);

	void updateViewCount(Map<String,Object> param);
	
	void updateBoardRecord(BoardRecord boardRecord);
	void updateRecruitRecord(RecruitRecord recruitRecord);
	void updateConsultRecord(ConsultRecord consultRecord);
	void updateConsultAnswer(ConsultRecord consultRecord);
	void updateFaqRecord(FaqRecord faqRecord);
	void updateClubRecord(ClubRecord clubRecord);
	void updatePopupRecord(PopupRecord popupRecord);
	void updateTechRecord(TechRecord techRecord);
	void updateResultRecord(ResultRecord resultRecord);
	
	void deleteRecord(Map<String,Object> paramMap);
}