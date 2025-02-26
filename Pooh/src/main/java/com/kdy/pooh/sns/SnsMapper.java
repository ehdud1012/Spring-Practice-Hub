package com.kdy.pooh.sns;

import java.util.List;

public interface SnsMapper {
	public abstract int snsDelete(Sns s);
	public abstract int write(Sns s);
	public abstract int getPostCount(SnsPostPager sp);
	public abstract int postUpdate(Sns s);
	public abstract List<Sns> snsGet(SnsPostPager sp);
	
	public abstract int replyWrite(SnsReply sr);
	public abstract List<SnsReply> snsReplyGet(Sns s);
	public abstract int replyUpdate(SnsReply sr);
	public abstract int replyDelete(SnsReply sr);
	
}
