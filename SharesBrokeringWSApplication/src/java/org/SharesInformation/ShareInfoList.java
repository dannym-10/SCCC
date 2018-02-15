/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SharesInformation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danny
 */
public class ShareInfoList {
    protected List<ShareInfo> shareInfo;
    
    public List<ShareInfo> getShareInfo() {
        if (shareInfo == null) {
            shareInfo = new ArrayList<ShareInfo>();
        }
        return this.shareInfo;
    }
}
