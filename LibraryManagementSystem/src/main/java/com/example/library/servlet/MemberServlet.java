package com.example.library.servlet;

import com.example.library.model.Member;
import com.example.library.service.MemberService;
import com.example.library.util.CorsUtil;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberServlet extends HttpServlet {

    private final MemberService memberService;
    private final Gson gson;

    public MemberServlet(MemberService memberService) {
        this.memberService = memberService;
        this.gson = new Gson();
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CorsUtil.setCorsHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CorsUtil.setCorsHeaders(resp);
        String path = req.getPathInfo();
        resp.setContentType("application/json");
        if (path == null || path.equals("/")) {
            List<Member> members = memberService.getAllMembers();
            resp.getWriter().write(gson.toJson(members));
        } else {
            try {
                int id = Integer.parseInt(path.substring(1));
                Member member = memberService.getMemberById(id);
                if (member != null) {
                    resp.getWriter().write(gson.toJson(member));
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    resp.getWriter().write("{\"error\":\"Member not found\"}");
                }
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.getWriter().write("{\"error\":\"Invalid member ID\"}");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CorsUtil.setCorsHeaders(resp);
        Member member = gson.fromJson(req.getReader(), Member.class);
        memberService.addMember(member);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write(gson.toJson(member));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CorsUtil.setCorsHeaders(resp);
        Member member = gson.fromJson(req.getReader(), Member.class);
        boolean updated = memberService.updateMember(member);
        if (updated) {
            resp.getWriter().write(gson.toJson(member));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"error\":\"Member not found\"}");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CorsUtil.setCorsHeaders(resp);
        String path = req.getPathInfo();
        if (path == null || path.equals("/")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\":\"Member ID is required\"}");
            return;
        }

        try {
            int id = Integer.parseInt(path.substring(1));
            boolean deleted = memberService.deleteMember(id);
            if (deleted) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("{\"error\":\"Member not found\"}");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\":\"Invalid member ID\"}");
        }
    }
}
