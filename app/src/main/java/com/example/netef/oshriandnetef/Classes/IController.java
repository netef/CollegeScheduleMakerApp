package com.example.netef.oshriandnetef.Classes;

import com.example.netef.oshriandnetef.CreateNewCourse;

interface IController {

    void invokeConroller(String command, Object object);

    void removeViewer(IView viewer);
}
