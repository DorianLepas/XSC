package cea.language.sml.fileType;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class SmlFileTypeFactory extends FileTypeFactory
{
  // Inner classes

  // Instance fields

  // Static code

  // Constructors

  // Methods
  @Override
  public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
    fileTypeConsumer.consume(SmlFileType.INSTANCE);
  }
}
