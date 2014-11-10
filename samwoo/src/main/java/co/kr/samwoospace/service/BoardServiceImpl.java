package co.kr.samwoospace.service;


import java.util.List;

import javax.annotation.Resource;

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
import co.kr.samwoospace.dao.boardDAO;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.util.Paging;
import co.kr.samwoospace.util.StringUtility;

public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAO")
	private boardDAO boardDao;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="stringUtility")
	private StringUtility stringUtil;
	
	@Resource(name="fileService")
	private FileService fileService;
		
	@Override
	public List<BoardRecord> ListBoardRecord(Paging paging) {
		return boardDao.selectListBoardRecord(paging);
	}
	
	@Override
	public List<RecruitRecord> ListRecruitRecord(Paging paging) {
		return boardDao.selectListRecruitRecord(paging);
	}

	@Override
	public List<ConsultRecord> ListConsultRecord(Paging paging) {
		return boardDao.selectListConsultRecord(paging);
	}
	
	@Override
	public List<ClubRecord> ListClubRecord(Paging paging) {
		return boardDao.selectListClubRecord(paging);
	}
	
	@Override
	public List<ClubInfoRecord> ListClubInfoRecord(Paging paging) {
		return boardDao.selectListClubInfoRecord(paging);
		
	}

	@Override
	public List<PopupRecord> ListPopupRecord(Paging paging) {
		return boardDao.selectListPopupRecord(paging);
	}
	
	@Override
	public List<PopupRecord> indexPopupList() {
		return boardDao.indexPopupList();
	}
	
	@Override
	public List<TechRecord> ListTechRecord(Paging paging) {
		return boardDao.selectListTechRecord(paging);
	}
	
	
	@Override
	public List<ResultRecord> ListResultRecord(Paging paging) {
		return boardDao.selectListResultRecord(paging);
	}
	
	@Override
	public List<FaqRecord> ListFaqRecord(Paging paging) {
		return boardDao.selectListFaqRecord(paging);
	}
	
	@Override
	public List<ClubInfoRecord> ListAllClubInfoRecord() {
		return boardDao.selectAllListClubInfoRecord();
	}
	
	@Override
	public Paging selectPagingInfo(String bbsId, String pageURL, int pageNum) {
		Paging paging = boardDao.selectPagingInfo(bbsId);
		int totalCount = this.selectTotalCount(paging);
		paging.setTotalCount(totalCount);
		paging.setPageNum(pageNum);
		paging.setPageURL(pageURL);
		return paging;
	}
	
	@Override
	public Paging selectPagingInfoByCondition(String bbsId, String pageURL, int pageNum, int pageSize, Param<?,?> param) {
		Paging paging = boardDao.selectPagingInfo(bbsId);
		paging.setParam(param);
		paging.setPageSize(pageSize);
		int totalCount = this.selectTotalCount(paging);
		paging.setTotalCount(totalCount);
		paging.setPageNum(pageNum);
		paging.setPageURL(pageURL);
		return paging;
	}
	
	@Override
	public int selectTotalCount(Paging paging) {
		return boardDao.selectTotalCount(paging);
	}
	
	@Override
	public void updateViewCount(String bbsId, int num) {
		Param<String,Object> param = new Param<String,Object>();
		param.put("bbsId", bbsId);
		param.put("boardNum", num);
		boardDao.updateViewCount(param);
	}
	
	@Override
	public ResponStatus updateBoardRecord(BoardRecord boardRecord, MultipartHttpServletRequest request) {
		boardDao.updateBoardRecord(boardRecord);
		ResponStatus respon = fileService.FileUpload(request, boardRecord.getNum(), boardRecord.getBbsId(), true);
		return respon;
	}

	@Override
	public BoardRecord selectOneBoardRecord(int num) {				
		return boardDao.selectOneBoardRecord(num);
	}
	
	@Override
	public TechRecord selectOneTechRecord(int num) {
		return boardDao.selectOneTechRecord(num);
	}

	@Override
	public RecruitRecord selectOneRecruitRecord(int num) {
		return boardDao.selectOneRecruitRecord(num);
	}

	@Override
	public ConsultRecord selectOneConsultRecord(int num) {
		return boardDao.selectOneConsultRecord(num);
	}
	
	@Override
	public ClubRecord selectOneClubRecord(int num) {
		return boardDao.selectOneClubRecord(num);
	}
	
	@Override
	public PopupRecord selectOnePopupRecord(int num) {
		return boardDao.selectOnePopupRecord(num);
	}
	
	@Override
	public ResultRecord selectOneResultRecord(int num) {
		return boardDao.selectOneResultRecord(num);
	}
	
	@Override
	public FaqRecord selectOneFaqRecord(int num) {
		return boardDao.selectOneFaqRecord(num);
	}
	
	@Override
	public ClubInfoRecord selectOneClubInfoRecord(int num) {
		return boardDao.selectOneClubInfoRecord(num);
	}
	
	@Override
	public ResponStatus insertBoardRecord(BoardRecord boardRecord, MultipartHttpServletRequest request) {
		boardDao.insertBoardRecord(boardRecord);
		
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, boardRecord.getBbsId(), true);
		return respon;
	}
	
	@Override
	public ResponStatus insertRecruitRecord(RecruitRecord recruitRecord, MultipartHttpServletRequest request) {
		boardDao.insertRecruitRecord(recruitRecord);
	
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, recruitRecord.getBbsId(), true);
		return respon;
	}

	@Override
	public ResponStatus insertConsultRecord(ConsultRecord consultRecord, MultipartHttpServletRequest request) {
		boardDao.insertConsultRecord(consultRecord);
	
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, consultRecord.getBbsId(), true);
		return respon;
	}
	
	@Override
	public ResponStatus insertClubRecord(ClubRecord clubRecord, MultipartHttpServletRequest request) {
		boardDao.insertClubRecord(clubRecord);	
	
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, clubRecord.getBbsId(), false);
		return respon;
	}
	
	@Override
	public ResponStatus insertPopupRecord(PopupRecord popupRecord, MultipartHttpServletRequest request) {
		boardDao.insertPopupRecord(popupRecord);
	
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, popupRecord.getBbsId(), false);
		return respon;
	}
	
	@Override
	public ResponStatus insertTechRecord(TechRecord techRecord, MultipartHttpServletRequest request) {
		boardDao.insertTechRecord(techRecord);
	
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, techRecord.getBbsId(), false);
		return respon;
	}
	
	
	@Override
	public ResponStatus insertResultRecord(ResultRecord resultRecord, MultipartHttpServletRequest request) {
		boardDao.insertResultRecord(resultRecord);
		
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, resultRecord.getBbsId(), false);
		return respon;
	}

	@Override
	public void insertFaqRecord(FaqRecord faqRecord, MultipartHttpServletRequest request) {
		boardDao.insertFaqRecord(faqRecord);
	}

	@Override
	public ResponStatus insertClubInfoRecord(ClubInfoRecord clubInfoRecord, MultipartHttpServletRequest request) {
		boardDao.insertClubInfoRecord(clubInfoRecord);
		
		int boardNum = boardDao.selectLastId();
		ResponStatus respon = fileService.FileUpload(request, boardNum, clubInfoRecord.getBbsId(), false);
		return respon;
	}
	
	@Override
	public void deleteRecord(String bbsId, int num) {
		Param<String,Object> param = new Param<String,Object>();
		param.put("bbsId", bbsId);
		param.put("num", num);
		boardDao.deleteRecord(param);
	}

	@Override
	public ResponStatus updateRecruitRecord(RecruitRecord recruitRecord, MultipartHttpServletRequest request) {
		boardDao.updateRecruitRecord(recruitRecord);
		ResponStatus respon = fileService.FileUpload(request, recruitRecord.getNum(), recruitRecord.getBbsId(), true);
		return respon;
	}

	@Override
	public void updateFaqRecord(FaqRecord faqRecord) {
		boardDao.updateFaqRecord(faqRecord);
	}

	@Override
	public ResponStatus updateConsultRecord(ConsultRecord consultRecord, MultipartHttpServletRequest request) {
		boardDao.updateConsultRecord(consultRecord);
		ResponStatus respon = fileService.FileUpload(request, consultRecord.getNum(), consultRecord.getBbsId(), true);
		return respon;
	}

	@Override
	public ResponStatus updateClubRecord(ClubRecord clubRecord, MultipartHttpServletRequest request) {
		boardDao.updateClubRecord(clubRecord);
		ResponStatus respon = fileService.FileUpload(request, clubRecord.getNum(), clubRecord.getBbsId(), false);
		return respon;
	}

	@Override
	public void updateConsultAnswer(ConsultRecord consultRecord) {
		boardDao.updateConsultAnswer(consultRecord);
	}
	
	@Override
	public ResponStatus updateTechRecord(TechRecord techRecord, MultipartHttpServletRequest request) {
		boardDao.updateTechRecord(techRecord);
		ResponStatus respon = fileService.FileUpload(request, techRecord.getNum(), techRecord.getBbsId(), false);
		return respon;
	}

	@Override
	public ResponStatus updateResultRecord(ResultRecord resultRecord, MultipartHttpServletRequest request) {
		boardDao.updateResultRecord(resultRecord);
		ResponStatus respon = fileService.FileUpload(request, resultRecord.getNum(), resultRecord.getBbsId(), false);
		return respon;
	}

	@Override
	public ResponStatus updatePopupRecord(PopupRecord popupRecord, MultipartHttpServletRequest request) {
		boardDao.updatePopupRecord(popupRecord);
		ResponStatus respon = fileService.FileUpload(request, popupRecord.getNum(), popupRecord.getBbsId(), false);
		return respon;
	}
	
	@Override
	public ResponStatus updateClubInfoRecord(ClubInfoRecord clubInfoRecord, MultipartHttpServletRequest request) {
		boardDao.updateClubInfoRecord(clubInfoRecord);
		ResponStatus respon = fileService.FileUpload(request, clubInfoRecord.getNum(), clubInfoRecord.getBbsId(), false);
		return respon;
	}
	
	@Override
	public int selectLastId() {
		return boardDao.selectLastId();
	}

	

	

	

	
	

}
