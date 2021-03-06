package com.bellman.bible.service.format.osistohtml.taghandler;

import com.bellman.bible.service.common.Constants.HTML;
import com.bellman.bible.service.common.Logger;
import com.bellman.bible.service.format.osistohtml.HtmlTextWriter;
import com.bellman.bible.service.format.osistohtml.OsisToHtmlParameters;
import com.bellman.bible.service.format.osistohtml.osishandlers.OsisToHtmlSaxHandler.PassageInfo;

import org.crosswire.jsword.book.OSISUtil;
import org.xml.sax.Attributes;

/** Line break
 * 
 * @author Martin Denham [mjdenham at gmail dot com]
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's author. 
 */
public class LbHandler implements OsisTagHandler {

	@SuppressWarnings("unused")
	private static final Logger log = new Logger("LHandler");
	private PassageInfo passageInfo;
	private HtmlTextWriter writer;
	@SuppressWarnings("unused")
	private OsisToHtmlParameters parameters;

	public LbHandler(OsisToHtmlParameters parameters, PassageInfo passageInfo, HtmlTextWriter writer) {
		this.parameters = parameters;
		this.passageInfo = passageInfo;
		this.writer = writer;
	}
	
	@Override
	public String getTagName() {
        return OSISUtil.OSIS_ELEMENT_LB;
    }

	@Override
	public void start(Attributes attrs) {
		if (passageInfo.isAnyTextWritten) {
			writer.write(HTML.BR);
		}
	}

	@Override
	public void end() {
	}
}
