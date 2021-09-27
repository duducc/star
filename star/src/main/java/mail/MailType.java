package mail;
public enum MailType
{
  IMG, FILE;

  public String toString()
  {
    String message = null;
    switch (this) {
    case FILE:
      message = ",包含图片";
    }
    message = ",包含附件";

    return message;
  }
}