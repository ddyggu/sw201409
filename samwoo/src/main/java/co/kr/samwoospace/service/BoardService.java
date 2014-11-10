package co.kr.samwoospace.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.samwoospace.bean.BoardRecord;
import co.kr.samwoospace.bean.ClubInfoRecord;
import co.kr.samwoospace.bean.ClubRecord;
import co.kr.samwoospace.bean.ConsultRecord;
import co.kr.samwoospace.bean.FaqRecord;
import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.bean.PopupRecord;
import co.kr.samwoospace.bean.RecruitRecord;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.bean.ResultRecord;
import co.kr.samwoospace.bean.TechRecord;
import co.kr.samwoospace.util.Paging;

public interface BoardService {

	List<BoardRecord> ListBoardRecord(Paging paging);
	List<TechRecord> ListTechRecord(Paging paging);
	List<RecruitRecord> ListRecruitRecord(Paging paging);
	List<ConsultRecord> ListConsultRecord(Paging paging);
	List<FaqRecord> ListFaqRecord(Paging paging);
	List<ClubRecord> ListClubRecord(Paging paging);
	List<ClubInfoRecord> ListClubInfoRecord(Paging paging);
	List<ClubInfoRecord> ListAllClubInfoRecord();
	List<PopupRecord> ListPopupRecord(Paging paging);
	List<PopupRecord> indexPopupList();
	List<ResultRecord> ListResultRecord(Paging paging);
	
	BoardRecord selectOneBoardRecord(int num);
	TechRecord selectOneTechRecord(int num);
	RecruitRecord selectOneRecruitRecord(int num);
	ConsultRecord selectOneConsultRecord(int num);
	FaqRecord selectOneFaqRecord(int num);
	ClubRecord selectOneClubRecord(int num);
	ClubInfoRecord selectOneClubInfoRecord(int num);
	PopupRecord selectOnePopupRecord(int num);
	ResultRecord selectOneResultRecord(int num);
	
	int selectLastId();
	int selectTotalCount(Paging paging);
	Paging selectPagingInfo(String bbsId, String pageURL, int pageNum);
	
	Paging selectPagingInfoByCondition(String bbsId, String pageURL, int pageNum, int pageSize, Param<?, ?> param);
	
	void insertFaqRecord(FaqRecord faqRecord, MultipartHttpServletRequest request);
	ResponStatus insertRecruitRecord(RecruitRecord recruitRecord, MultipartHttpServletRequest request);
	ResponStatus insertBoardRecord(BoardRecord boardRecord, MultipartHttpServletRequest request);
	ResponStatus insertConsultRecord(ConsultRecord consultRecord, MultipartHttpServletRequest request);
	ResponStatus insertClubRecord(ClubRecord clubRecord, MultipartHttpServletRequest request);
	ResponStatus insertClubInfoRecord(ClubInfoRecord clubRecord, MultipartHttpServletRequest request);
	ResponStatus insertPopupRecord(PopupRecord popupRecord, MultipartHttpServletRequest request);
	ResponStatus insertTechRecord(TechRecord techRecord, MultipartHttpServletRequest request);
	ResponStatus insertResultRecord(ResultRecord resultRecord, MultipartHttpServletRequest request);
	
	void updateViewCount(String bbsId, int num);
	void updateFaqRecord(FaqRecord faqRecord);
	void updateConsultAnswer(ConsultRecord consultRecord);
	ResponStatus updateBoardRecord(BoardRecord boardRecord, MultipartHttpServletRequest request);
	ResponStatus updateRecruitRecord(RecruitRecord recuirtRecord, MultipartHttpServletRequest request);
	ResponStatus updateConsultRecord(ConsultRecord consultRecord, MultipartHttpServletRequest request);
	ResponStatus updateClubRecord(ClubRecord clubRecord, MultipartHttpServletRequest request);
	ResponStatus updateClubInfoRecord(ClubInfoRecord clubRecord, MultipartHttpServletRequest request);
	ResponStatus updatePopupRecord(PopupRecord popupRecord, MultipartHttpServletRequest request);
	ResponStatus updateTechRecord(TechRecord techRecord, MultipartHttpServletRequest request);
	ResponStatus updateResultRecord(ResultRecord resultRecord, MultipartHttpServletRequest request);
	
	void deleteRecord(String bbsId, int num);
	
	
}
