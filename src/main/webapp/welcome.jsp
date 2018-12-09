<%@page import="fr.aubin.opiyou.domain.Youtuber"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="parts/header.jsp" %>
    </head>
    <body>
        <p>Bonjour : <c:out value="${youtuber.firstnameYoutuber}" /></p>
        <p>tu as : <c:out value="${youtuber.subscribersCount}" /> abonnés</p>
        <div>
            <table>
                <tr>
                    <th>Nom de OP</th>
                    <th>Nom entreprise</th>
                    <th>Description</th>
                    <th>Rémunération</th>
                </tr>
                <c:forEach items="${listCommercials}" var="commercial">
                    <c:if test="${youtuber.subscribersCount>commercial.minSubs}">
                        <tr>
                            <td><c:out value="${commercial.commercialName}" /></td>
                            <td><c:out value="${commercial.corporateName}" /></td>
                            <td><c:out value="${commercial.commercialDescription}" /></td>
                            <td><c:out value="${commercial.commercialRemuneration}" /></td>
                        </tr>
                    </c:if>
                </c:forEach>
            <table>
        </div>
    </body>
</html>