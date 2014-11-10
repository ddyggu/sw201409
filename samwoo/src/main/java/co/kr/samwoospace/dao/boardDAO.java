package co.kr.samwoospace.dao;

import java.util.List;

import java.util.Map;

import co.kr.samwoospace.bean.BoardRecord;
import co.kr.samwoospace.bean.ClubInfoRecord;
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
	List<PopupRecord> indexPopupList();
	List<TechRecord> selectListTechRecord(Paging paging);
	List<ResultRecord> selectListResultRecord(Paging paging);
	List<ClubInfoRecord> selectListClubInfoRecord(Paging paging);
	List<ClubInfoRecord> selectAllListClubInfoRecord();
	List<ResultRecord> selectListResultRecordByDivision(Map<String,Object> hashMap);
	List<RecruitRecord> selectListRecruitRecord(int pageNum);
	
	BoardRecord selectOneBoardRecord(int num);
	RecruitRecord selectOneRecruitRecord(int num);
	FaqRecord selectOneFaqRecord(int num);
	ConsultRecord selectOneConsultRecord(int num);
	ClubRecord selectOneClubRecord(int num);
	ClubInfoRecord selectOneClubInfoRecord(int num);
	PopupRecord selectOnePopupRecord(int num);
	TechRecord selectOneTechRecord(int num);
	ResultRecord selectOneResultRecord(int num);
	
	int selectTotalCount(Paging paging);
	int selectTotalCountResult(Map<String,Object> paramMap);
	
	void insertBoardRecord(BoardRecord boardRecord);
	void insertRecruitRecord(RecruitRecord recruitRecord);
	void insertConsultRecord(ConsultRecord consultRecord);
	void insertClubRecord(ClubRecord clubRecord);
	void insertClubInfoRecord(ClubInfoRecord clubInfoRecord);
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
	void updateClubInfoRecord(ClubInfoRecord clubRecord);
	void updatePopupRecord(PopupRecord popupRecord);
	void updateTechRecord(TechRecord techRecord);
	void updateResultRecord(ResultRecord resultRecord);
	
	void deleteRecord(Map<String,Object> paramMap);
}