package com.asiainfo.p6.multiThreads.homework;

/**
 * 多线程在工作中的使用场景：</p>
 * 需求：员工表有100多万的员工数据，将每一个员工数据取出调用外围系统的一个接口来判断该员工在外围系统是否存在，调用的结果会放入另一张表。</p>
 * 如果用一个线程来跑的话会很慢，后来改用多线程来优化。线程的个数使用数据总量对每个线程处理量进行取模，模值就是线程的数量。每个线程处理的数据段是不一样的，比如第一个线程处理id为1-1000的数据，第二个线程处理1001-2000的数据等。
 *
 * @author zhangzhiwang
 * @date Aug 12, 2019 2:47:14 PM
 */
//@Controller
//@RequestMapping("/employee")
public class EmployeeController {
//	private static final Log LOGGER = LogFactory.getLog(EmployeeController.class);
//
//	@Autowired
//	private IErpEmpInfoTempService erpEmpInfoTempServiceImpl;
//
//	@RequestMapping("/getErpEmpInfoByCodeLoop")
//	public void getErpEmpInfoByCodeLoop() throws Exception {
//		int totalCount = erpEmpInfoTempServiceImpl.queryTotalCount();
//		String pageSizeStr = PropertyUtil.getProperty("erp.properties", "pageSize");
//		checkArguments(StringUtils.isNotBlank(pageSizeStr), ErrorEnum.PAGE_SIZE_IS_EMPTY.getName());
//		int pageSize = Integer.parseInt(pageSizeStr);
//		int loopCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
//		LOGGER.info("共启动" + loopCount + "个线程！");
//		for (int pageNo = 1; pageNo <= loopCount; pageNo++) {
//			LOGGER.info("启动第" + pageNo + "个线程！");
//			new MyThread(pageNo, pageSize).start();
//		}
//	}
//
//	class MyThread extends Thread {
//		private int pageNo; 
//		private int pageSize;
//
//		public MyThread(int pageNo, int pageSize) {
//			super();
//			this.pageNo = pageNo;
//			this.pageSize = pageSize;
//		}
//
//		public MyThread() {
//			super();
//		}
//
//		@Override
//		public void run() {
//			try {
//				int start = (pageNo - 1) * pageSize;
//				LOGGER.info("第" + pageNo + "次循环处理起始位置为" + (start + 1));
//				LOGGER.info("本次查询" + pageSize + "条数据...");
//				List<ERPSecStaff> queryAllWithPageList = erpEmpInfoTempServiceImpl.queryAllWithPage(start, pageSize);
//				checkArguments(CollectionUtils.isNotEmpty(queryAllWithPageList), ErrorEnum.QUERY_EMP_ERR.getName());
//				for (ERPSecStaff erpSecStaff : queryAllWithPageList) {
//					JSONObject jsonObject = new JSONObject();
//					jsonObject.put("erpCode", erpSecStaff.getStaffCode());
//					jsonObject.put("erpName", erpSecStaff.getStaffName());
//					String result = null;
//					try {
//						result = erpEmpInfoTempServiceImpl.getErpEmpInfoByCode(jsonObject.toJSONString());
//					} catch (Exception e) {
//						LOGGER.error("MyThread err:", e);
//					}
//					result = result.trim().replace("\\t", "").replace("\t", "").replace("\\r\\n", "").replace("\r\n", "");
//					JSONObject parseObject = JSONObject.parseObject(result);
//					JSONArray jsonArray = parseObject.getJSONArray("data");
//					for (int i = 0; i < jsonArray.size(); i++) {
//						JSONObject perJsonObj = jsonArray.getJSONObject(i);
//						ERPStaffInfo erpStaffInfo = JSONObject.toJavaObject(perJsonObj, ERPStaffInfo.class);
//						erpEmpInfoTempServiceImpl.insertERPStaffInfo(erpStaffInfo);
//					}
//				}
//			} catch (Exception e) {
//				LOGGER.error("MyThread err:", e);
//			}
//		}
//	}
}
