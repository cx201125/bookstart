<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css" />
<script
	src="${pageContext.request.contextPath}/bs/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/bs/js/bootstrap.min.js"></script>
<style type="text/css">
body{
font-size: 18px;
font-family: "微软雅黑";
color: white;

}
p{
text-indent:36px;
}

</style>
</head>
<body>
	<!-- 头部分 -->
	<%@ include file="longo.jsp"%>
	<!-- 导航栏部分 -->
	<%@ include file="navigation.jsp"%>
      <p>&nbsp;</p>
	<div class="container" style=" background-color:#f20c00;">
		
		<p>
			重庆城市职业学院104有限公司(以下简称广州建筑)是广州市国资委直接监管的国有大型企业集团，2015年营业收入达410亿元，跻身2015年中国企业500强第309位、广东省企业500强第38位，是华南地区首家同时持有房屋建筑工程施工总承包特级和建筑行业(建筑工程)甲级资质、市政公用工程施工总承包特级资质和市政行业甲级设计资质的企业集团，综合实力居广东省建筑业企业之首。集团现有总资产200亿元，全资和控股企业172家，拥有施工总承包特级资质2项、施工总承包一级资质34项、专业承包一级资质73项，主要业务涵盖工程施工、市政隧道、公路建设、机电安装、国际工程、人力资源服务、海外劳务、国际贸易、建筑装饰、建筑设计、项目代建、项目融投资、房地产开发经营、新材料研发与经营、建材供应、建机生产、科学研究、环保工程、金融服务等领域，基本覆盖了建筑行业的全部专业范畴。</p>
		<p>
			自1950年成立以来，广州建筑已历经广州市国营建筑工程公司、广州市建筑工程局、广州市建筑总公司等发展阶段，并于1996年转制为有限公司，2008年与广州市市政集团、广州工程总承包集团合并重组，2010年将中国广州国际经济技术合作公司纳入作为子公司管理，同时发起设立广州建筑股份有限公司，将原有建筑主业施工资质及与建筑施工有关的业绩变更到股份公司。成立60余年来，作为广州城市建设的主力军，广州建筑承担了各个时期广州大部分城市基础设施和标志性工程的建设，累计竣工面积达7000万平方米，相当于再造了6座旧广州城。近年来先后承建了广州大学城、广州国际会议展览中心、中信广场、广州新电视塔、广州国际金融中心(西塔)、广州大剧院、珠江新城核心区市政交通项目等一批标志性工程，特别是承建了以广州亚运会开闭幕式场馆&mdash;&mdash;海心沙广场为代表的140多项亚运工程，为广州亚运会的顺利举办做出了突出贡献。</p>
		<p>
			精品出自雕琢，成功始于执着。强优的品牌形象源自对工程质量精益求精的努力和对科技兴企孜孜不倦的追求。广州建筑历年来共获得中国建设工程鲁班奖21项，中国土木工程詹天佑奖17项，中国市政金杯示范工程奖36项，国家优质工程奖29项。多次获得全国先进建筑施工企业、全国建筑业科技进步与技术创新先进企业、全国守合同重信用企业、企业信用等级AAA级单位等荣誉称号;拥有1个科研院、3个博士后工作站、1个国家级工程中心(国家建筑工程技术研究中心华南分中心)、4个省级工程中心、6个省级企业技术中心、11个高新技术企业、1个广东省创新型企业、1个广东省新型研发机构、1个广东省绿色建筑与新型建材产学研合作创新平台、4个广州市创新型企业、4个设计院;先后有323项科技成果通过了省科技厅、建设厅的科技成果鉴定，多数成果被评为国内领先及以上水平;共获得210项各类科学技术奖，其中1项国家技术发明二等奖，1项国家科学技术奖励二等奖，1项中国专利奖，176项省部级科技进步奖;主编或参编国家标准、行业标准、地方标准80多项;拥有发明专利76项，实用新型专利211项，国际专利2项;获得国家级工法30项。</p>
		<p>
			百舸争流千帆竞，长风破浪正当时。在市委、市政府新一轮发展规划和布局的指导下，广州建筑结合自身实际，制定了新一轮发展规划，明确打造具有&ldquo;广州建筑&rdquo;品牌特色的国内一流大型综合性企业集团的发展目标。围绕规划任务目标，集团加快企业股份制改造，促进产业转型升级，提升核心能力，在做大做强施工总承包主业的基础上，着力推进主业结构调整和专业板块整合，调整形成了工程建设与服务、新材料研发与经营和房地产开发经营等三大主业板块，为下一步实现转型升级奠定了坚实的基础。广州建筑即将迎来新一轮的大发展。</p>
		<p>我们坚信，在全体员工的共同努力和社会各界的大力支持下，广州建筑必将以更优质的服务、更辉煌的业绩真诚回报社会!</p>
		<p>
			<p>
　　浙江百慕生物科技有限公司隶属浙江丽珀集团，成立于2011年3月，注册资本1000万元，是一家从事海洋生物开发销售的公司，主要从事保健品(海参)产品的销售。</p>
<p>
　　旗下的优参堂海参品牌源自于卢炜翎先生创立的优参号参堂，经过一百多年的发展，现已成为最具规模化，现代化，专业化的海参加工生产企业之一。</p>
<p>
　　公司特与世纪联华超市股份有限公司、物美商业集团股份有限公司、天天好大药房等合作，在浙江省多个城市100多家门店进行销售。此外公司还搭档杭州电视台生活频道《生活大参考》、杭州电视台生活频道电商平台共同进行优参堂海参的销售，致力于将品牌以更多样化的形式进行推广，将产品以更方便快捷的渠道送达到消费者手中。</p>
<p>
　　公司本着&ldquo;客户至上，质量为本&rdquo;的原则，建立健全了严苛的质量标准检验体系，除了通过国家食品认证体系之外，还委托国家轻工业食品质量监督检测杭州站特别做了农药、兽药残留检测，海水污染检测，以远远低于国家标准的检测结果确保海参品质。</p>
<h2>
	</div>
</body>
</html>